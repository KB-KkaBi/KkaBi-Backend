package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.User;
import com.project.dto.AccoutListRequestDTO;
import com.project.service.AccountListService;

@RestController
public class AccountListController {
	@Autowired
	private AccountListService accountListService;
	 
	@PostMapping("/create-account")
	public AccountList insert(@RequestBody AccoutListRequestDTO requestData, HttpSession session) {	
		
		AccountList accountList = new AccountList(requestData);
		/**
		 * 로그인 완성되면 session으로 받아오게 로직 수정하기
		 */
//		accountList.setUser((User)session.getAttribute("loginUser"));
		
		AccountList accountlist=accountListService.insertNewAccount(accountList);
		
		return accountlist;
	}
	
}
