package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.AccountLogService;
import com.project.domain.AccountLog;

@RestController
public class AccountLogController {
	
	@Autowired
	private AccountLogService accountLogService;
	
	@PostMapping("/account-log")
	public AccountLog insertAccountLog(AccountLog accountLog) {
		
		AccountLog dbAccountLog = accountLogService.insertAccountLog(accountLog);
		
		return dbAccountLog;
	}
	

}
