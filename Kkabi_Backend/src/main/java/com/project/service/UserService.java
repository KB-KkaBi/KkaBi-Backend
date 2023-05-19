package com.project.service;

import com.project.domain.User;

public interface UserService {
	

	boolean isEmailExists(String email);
	User signUp(User user);

	/**
	 * 로그인하기
	 * @작성자 : 곽승규
	 * */
	User signIn(User user);

}
