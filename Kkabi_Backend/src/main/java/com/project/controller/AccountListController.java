package com.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/get-account-all")
	public List<AccountList> selectMyAccountList(HttpSession sessoin){
		
		User user = (User) sessoin.getAttribute("loginUser");
				
		List<AccountList> accountList = accountListService.selectMyAccountList(user.getUserSeq());
		
		return accountList;
		
	}
	
	@GetMapping("/bank")
	public AccountList selectCurrentMyAccount(@RequestParam int accountId) {
		
		AccountList accountList = accountListService.selectCurrentMyAccount(accountId);
		
		return accountList;
	}
	
	
}
