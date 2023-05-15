package com.project.Service;

import com.project.domain.AccountLog;
import com.project.repository.AccountLogRepository;

public class AccountLogServiceImpl implements AccountLogService{
	
	private AccountLogRepository AccountLogRep;

	@Override
	public AccountLog insertAccountLog(AccountLog accountLog) {
		AccountLog accountLogNew = AccountLogRep.save(accountLog);
		System.out.println(accountLogNew);
		return accountLogNew;
	}

}
