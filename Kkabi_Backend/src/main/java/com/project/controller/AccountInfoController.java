package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.AccountInfoService;
import com.project.domain.AccountInfo;
import com.project.domain.AccountList;

@RestController
public class AccountInfoController {
	@Autowired
	private AccountInfoService accountInfoService;
	
	
	@GetMapping("/account-info")
	public List getAccountList() {
		List<AccountInfo> list= accountInfoService.selectAll();
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/create-account")
	public AccountList postAccountList(int accountId, String accountName) {
		AccountList list=accountInfoService.insert(accountId, accountName);
		return list;
	}
}
