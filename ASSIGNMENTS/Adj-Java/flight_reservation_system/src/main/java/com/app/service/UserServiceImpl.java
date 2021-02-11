package com.app.service;

import javax.transaction.Transactional;
import com.app.dao.UserRepository;
import com.app.pojos.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository dao;

	@Override
	public User authenticate(String email,String password) {	
		return dao.findByEmailAndPassword(email, password);
	}
	

}
