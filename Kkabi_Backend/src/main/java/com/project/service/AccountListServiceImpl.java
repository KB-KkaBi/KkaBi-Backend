package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.domain.User;
import com.project.dto.AccoutListRequestDTO;
import com.project.repository.AccountListRepository;
import javax.persistence.EntityManager;

@Service
@Transactional
public class AccountListServiceImpl implements AccountListService {

	@Autowired
	private AccountListRepository accountListRep;
	
	@Override
	public AccountList insertNewAccount(AccountList accountList) {		

		AccountList accountListNew=accountListRep.save(accountList);
		                           
		return accountListNew;
	}

}
