package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.service.AccountInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountInfoController {
	@Autowired
	private AccountInfoService accountInfoService;
	
	
	@ApiOperation(value = "계좌정보조회", notes = "계좌 정보들을 조회할 때 사용함")
	@GetMapping("/account-info")
	public List getAccountList() {
		List<AccountInfo> list= accountInfoService.selectAll();
		System.out.println(list);
		return list;
	}

}
