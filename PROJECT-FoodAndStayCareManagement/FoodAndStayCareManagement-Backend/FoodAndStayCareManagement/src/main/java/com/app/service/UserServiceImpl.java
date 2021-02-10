package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	public Optional<User> authenticateUser(String email,String password){
		return userRepo.findByEmailIdAndName(email,password);
	}
	
	@Override
	public User addUserDetails(User v) {
	
		return userRepo.save(v);
	}

	@Override
	public Optional<User> getUserByEmailId(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public void deleteUser(int id) {
			userRepo.deleteById(id);
	}

	@Override
	public User updateUserDetails(User user) {
		
			return userRepo.save(user); 
	
	}

	@Override
	public Optional<User> getUserById(int id) {
		
		return userRepo.findById(id);
	}

	@Override
	public List<User> getUserByRole(Role role) {
	
		return userRepo.findByRole(role);
	}
}