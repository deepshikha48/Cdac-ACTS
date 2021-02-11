package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface IUserService {

	 Optional<User> authenticateUser(String email,String password);
	 User addUserDetails(User v);
	 Optional<User> getUserByEmailId(String email);
	 void deleteUser(int id);
	 User updateUserDetails(User user);
	 Optional<User> getUserById(int id);
	List<User> getUserByRole(Role role);
}