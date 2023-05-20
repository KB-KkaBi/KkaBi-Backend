package com.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<AccountLog> selectAccoungLog(int accountId, Pageable page) {
		
		Page<AccountLog> accountLogList = accountLogRep.findAllByAccountListJPQL(accountId, page);
		
		return accountLogList;
	}
	
	

}
