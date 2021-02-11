package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private JavaMailSender mail;

	public UserController() {
		System.out.println("In ctor of " + getClass().getName());
	}

	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody User user) {
		try {
			User u = userService.addUserDetails(user);
			System.out.println(u);
			return new ResponseEntity<>(u, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);// 406
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUserLogin(@RequestBody User user) {
		Optional<User> validUser = userService.authenticateUser(user.getEmail(), user.getPassword());
		if (validUser.isPresent()) {
			return ResponseEntity.ok(validUser.get());
		}
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);// 401 code
	}

	@PostMapping("/search")
	public ResponseEntity<?> GetUserByEmail(@RequestBody String email) {
		Optional<User> user = userService.getUserByEmailId(email);
		if (user.isPresent())
			return ResponseEntity.ok(user.get());
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);// 403
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		try {
			userService.deleteUser(id);
		} catch (RuntimeException e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST); // 400
		}
	}

	@PutMapping
	public ResponseEntity<?> updateUserxDetails(@RequestBody User user) {

		Optional<User> tempUser = userService.getUserById(user.getId());
		if (tempUser.isPresent())
			return ResponseEntity.ok(userService.updateUserDetails(user));
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);//403

	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgetPassword(@RequestBody String email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("Login Details for FSCM");
		Optional<User> user = userService.getUserByEmailId(email);
		if (user.isPresent()) {
			User validUser = user.get();
			mailMessage.setText("Dear " + validUser.getFirstName() + ",\n\nUserId: " + email + "\nPassword: "
					+ validUser.getPassword() + "\n\nRegards,\nFSCM Family :)");
			mail.send(mailMessage);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);// 401

	}

	@GetMapping("/roles")
	public ResponseEntity<?> getAllRoles() {
		int counter = 0;
		Role[] names = Role.values();
		String[] roles = new String[(names.length) - 1];
		for (int i = 0; i < names.length; i++) {
			if (names[i].name() != "ADMIN")
				roles[counter++] = names[i].name();
		}
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@GetMapping("/list/{role}")
	public ResponseEntity<?> getUserList(@PathVariable String role) {

		List<User> users = new ArrayList<>();
		users = userService.getUserByRole(Role.valueOf(role));

		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

}