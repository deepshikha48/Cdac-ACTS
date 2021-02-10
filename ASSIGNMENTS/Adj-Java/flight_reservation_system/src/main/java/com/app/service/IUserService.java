package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	User authenticate(String email , String password);
}
