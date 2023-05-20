package com.project.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.InvestResult;
import com.project.domain.User;
import com.project.dto.InvestRequestDTO;
import com.project.service.InvestService;

@RestController
public class InvestController {

	@Autowired
	private InvestService investService;
	
	@PostMapping("/invest")
	public InvestResult invest(@RequestBody InvestRequestDTO request) {
		
		InvestResult result = investService.submit(request);
		return result;
	}
}
