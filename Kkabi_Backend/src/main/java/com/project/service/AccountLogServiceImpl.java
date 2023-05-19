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

	@Override
	public AccountLog insertAccountLog(AccountLog accountLog) {
		
		AccountLog accountLogNew = accountLogRep.save(accountLog);
		
		accountListRep.updateAccountMoney(accountLog.getAccountLogMoney(), accountLog.getAccountList().getAccountId());
		
		return accountLogNew;
	}
	

	@Override
	public List<AccountLog> selectAccoungLog(int accountId) {
		
		List<AccountLog> accountLogList = accountLogRep.findAllByAccountListJPQL(accountId);
		
		return accountLogList;
	}
	
	

}
