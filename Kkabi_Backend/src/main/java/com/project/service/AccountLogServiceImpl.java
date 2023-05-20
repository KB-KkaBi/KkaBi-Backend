package com.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountLog;
import com.project.repository.AccountListRepository;
import com.project.repository.AccountLogRepository;

@Service
@Transactional
public class AccountLogServiceImpl implements AccountLogService{
	
	@Autowired
	private AccountLogRepository accountLogRep;
	
	@Autowired
	private AccountListRepository accountListRep;
	
	@Autowired
	private AccountListService accountListService;

	@Override
	public AccountLog insertAccountLog(AccountLog accountLog){
		
		int accountId = accountLog.getAccountList().getAccountId();
		
		if(!accountListService.checkMyAccountMoney(accountId, (accountLog.getTransactionAmount() * -1))) {
			throw new RuntimeException("잔액이 부족합니다.");
		}else {
			AccountLog accountLogNew = accountLogRep.save(accountLog);
			
			accountListRep.updateAccountMoney(accountLog.getAccountLogMoney(), accountId);
			
			return accountLogNew;
		}
		
	}
	

	@Override
	public List<AccountLog> selectAccoungLog(int accountId) {
		
		List<AccountLog> accountLogList = accountLogRep.findAllByAccountListJPQL(accountId);
		
		return accountLogList;
	}
	
	

}
