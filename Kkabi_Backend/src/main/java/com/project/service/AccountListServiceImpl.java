package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountList;
import com.project.repository.AccountListRepository;

@Service
@Transactional
public class AccountListServiceImpl implements AccountListService {

	@Autowired
	private AccountListRepository accountListRep;
	
	@Override
	public AccountList insertAccountList(AccountList accountList) {
		AccountList accountListNew=accountListRep.save(accountList);
		System.out.println("account = "+accountListNew);
		
		return accountListNew;
	}

}
