package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.domain.User;
import com.project.service.AccountLogService;

@RestController
public class AccountLogController {
	
	@Autowired
	private AccountLogService accountLogService;
	
	@PostMapping("/account-log")
	public AccountLog insertAccountLog(AccountLog accountLog, int accountId) {
		AccountList accountList = new AccountList(accountId);
		accountLog.setAccountList(accountList);
		
		AccountLog dbAccountLog = accountLogService.insertAccountLog(accountLog);
		
		return dbAccountLog;
	}
	
	@GetMapping("/account-log")
	public List<AccountLog> selectAccountLog(int accountId){
		
		List<AccountLog> accountLogList = accountLogService.selectAccoungLog(accountId);
		
		return accountLogList;
	}
	

}
