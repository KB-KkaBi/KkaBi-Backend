package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountLog;
import com.project.repository.AccountLogRepository;

@Service
@Transactional
public class AccountLogServiceImpl implements AccountLogService{
	
	@Autowired
	private AccountLogRepository AccountLogRep;

	@Override
	public AccountLog insertAccountLog(AccountLog accountLog) {
		AccountLog accountLogNew = AccountLogRep.save(accountLog);
		
		return accountLogNew;
	}

}
