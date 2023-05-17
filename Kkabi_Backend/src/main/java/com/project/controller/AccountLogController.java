package com.project.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.dto.AccountLogRequest;
import com.project.service.AccountLogService;

@RestController
public class AccountLogController {
	
	@Autowired
	private AccountLogService accountLogService;
	
	/**
	 * 예금, 출금 이벤트로 post 요청이 오면 accountLog를 기록하는 method
	 * 
	 * @author awarduuu
	 * @param request
	 * @return 프론트에서 받을 AccountLog
	 */
	@PostMapping("/account-log")
	public AccountLog insertAccountLog(@RequestBody AccountLogRequest request) {
	    
	    AccountLog dbAccountLog = accountLogService.insertAccountLog(new AccountLog(request));
		 
//		AccountLog accountLog = new AccountLog();
//	    accountLog.setAccountLogMoney(request.getAccountLogMoney());
//	    accountLog.setTransactionType(request.getTransactionType());
//	    accountLog.setTransactionReason(request.getTransactionReason());
//	    accountLog.setTransactionAmount(request.getTransactionAmount());
//	    accountLog.setAccountList(new AccountList(request.getAccountId()));
//		
//	    AccountLog dbAccountLog = accountLogService.insertAccountLog(accountLog);
		return dbAccountLog;
	}
	
	/**
	 * 내 계좌 조회 버튼으로 get 요청이 오면 해당 계좌의 모든 accountLog를 불러와준다.
	 * 
	 * @author awarduuu
	 * @param accountId
	 * @return 조회된 accountLog의 리스트
	 */
	@GetMapping("/account-log")
	public List<AccountLog> selectAccountLog(int accountId){
		
		List<AccountLog> accountLogList = accountLogService.selectAccoungLog(accountId);
		
		return accountLogList;
	}
	

}
