package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.AccountLog;

import com.project.dto.AccountLogRequestDTO;
import com.project.service.AccountLogService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountLogController {
	
	@Autowired
	private AccountLogService accountLogService;
	
	/**
	 * 
	 * 
	 * @author awarduuu
	 * @param request
	 * @return 프론트에서 받을 AccountLog
	 */
	@PostMapping("/account-log")
	@ApiOperation(value="계좌 로그 기록 및 내 계좌 업데이트", notes="예금 or 출금 창의 확인 버튼을 누를 시 사용된다.")
	public AccountLog insertAccountLog(@RequestBody AccountLogRequestDTO request) {
	    
	    AccountLog dbAccountLog = accountLogService.insertAccountLog(new AccountLog(request));
		
		return dbAccountLog;
	}
	
	/**
	 * 
	 * 
	 * @author awarduuu
	 * @param accountId
	 * @return 조회된 accountLog의 리스트
	 */
	@GetMapping("/account-log")
	@ApiOperation(value="내 계좌 로그 조회", notes="내역 확인 버튼을 누를 시 사용된다.")
	public Page<AccountLog> selectAccountLog(int accountId, Model model, Pageable page){
		
		Page<AccountLog> accountLogList = accountLogService.selectAccoungLog(accountId, page);
		
		model.addAttribute("accountLogList", accountLogList);
		
		return accountLogList;
	}
	
	/**
	 * @author awarduuu
	 */
	@ApiOperation(value="모든 계좌 이자 지급" ,notes="매일 0시 0분 1초에 모든 계좌를 확인하여 이자를 지급할 때 사용된다.")
	@Scheduled(cron = "1 0 0 * * *")
	public void insertAccountLogForInterest() {
		accountLogService.insertAccountLogForInterest();
	}

}
