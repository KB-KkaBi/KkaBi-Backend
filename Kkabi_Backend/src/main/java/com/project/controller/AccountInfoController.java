package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountInfo;
import com.project.service.AccountInfoService;

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
}
