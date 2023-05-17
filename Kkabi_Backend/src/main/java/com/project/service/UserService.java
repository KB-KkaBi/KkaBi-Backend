package com.project.service;

import com.project.domain.User;

public interface UserService {

	/**
	 * 로그인하기
	 * @작성자 : 곽승규
	 * */
	User signIn(User user);

	/**
	 * 로그아웃하기
	 * @작성자 : 곽승규
	 * */
	User logout(int userSeq);
}