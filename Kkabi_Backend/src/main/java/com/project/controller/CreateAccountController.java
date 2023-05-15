package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountInfo;
import com.project.service.AccountInfoService;

@RestController
public class CreateAccountController {
	@Autowired
	private AccountInfoService accountInfoService;
	
	@GetMapping("/accountInfo")
	public String getAccountList() {
		AccountInfo accountInfo=(AccountInfo) accountInfoService.selectAll();
		
		return "redirect:/";
	}
}
