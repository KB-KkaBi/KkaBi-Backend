package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 로그인하기
	 * */
//	@PostMapping("/login")
//	public User signIn(User user, HttpSession session) {
//		AccountList accountList = new AccountList(accountId);
//		accountLog.setAccountListById(accountList);
//		
//		AccountLog dbAccountLog = accountLogService.insertAccountLog(accountLog);
//		
//		return dbAccountLog;
//	}
}
