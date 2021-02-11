package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.pojos.User;
import com.app.pojos.UserCard;
import com.app.service.IPassengerService;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IPassengerService passengerService;

	public UserController() {
		System.out.println("Constr: " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("ShowLoginForm: " + getClass().getName());
		return "/user/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam @NotBlank @Email String email, @RequestParam @NotBlank String password, Model modelMap,
			HttpSession hs) {
		System.out.println("ProcessLoginForm: email-" + email +" password-"+password);
		User validUser=userService.authenticate(email, password);
		if(validUser==null) {
			modelMap.addAttribute("mesg", "Invalid Login , Pls retry!!!!!!");
			return "/user/login";
		}else {
			hs.setAttribute("valid_user", validUser);
			return "redirect:/flight/search";
		}
	}
	
	@GetMapping("/card")
	public String showCardDetailsForm(UserCard card) {
		System.out.println("showCardDetailsForm: "+getClass().getName());
		return "/user/card";
	}
	
	@PostMapping("/card")
	public String processCardDetailsFormAndAddPassenger(@Valid UserCard card , HttpSession hs) {
		System.out.println("processCardDetailsFormAndAddPassenger: card-"+card);
		Passenger passenger=(Passenger)hs.getAttribute("passenger");
		Flight choosenFlight=(Flight)hs.getAttribute("choosen_flight");
		passenger.setBookedFight(choosenFlight);
		passenger=passengerService.savePassenger(passenger);
		return "redirect:/user/status";
	}
	
	@GetMapping("/status")
	public String showStatus() {
		System.out.println("showStatus: "+getClass().getName());
		return "/user/status";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpServletRequest request, HttpServletResponse resp,HttpSession hs,Model modelMap) {
		System.out.println("userLogout: "+getClass().getName());
		System.out.println("ctx path: " + request.getContextPath());
		User u=(User)hs.getAttribute("valid_user");
		hs.invalidate();
		modelMap.addAttribute("logout_msg", u.getName()+" is logging off now...");
		resp.setHeader("refresh", "5;url='" + request.getContextPath() + "/'");
		return "/user/logout";
	}
}
