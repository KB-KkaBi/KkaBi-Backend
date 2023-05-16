package com.project.service;

import com.project.domain.User;

public interface UserService {
	
	/**
	 * 로그인하기
	 * */
   User loginCheck(User user);
}
