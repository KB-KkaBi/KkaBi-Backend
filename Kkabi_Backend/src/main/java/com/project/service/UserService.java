package com.project.service;

import com.project.domain.User;

public interface UserService {
	boolean isEmailExists(String email);
	User signUp(User user);
	
	
}
