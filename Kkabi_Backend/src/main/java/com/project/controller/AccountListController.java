package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.domain.AccountList;
import com.project.service.AccountListService;

public class AccountListController {
	@Autowired
	private AccountListService accountListService;
	 
	@PostMapping("/create-account")
	public AccountList insert(AccountList accountlist) {
		AccountList list=accountListService.insertAccountList(accountlist);
		
		return list;
	}
}
