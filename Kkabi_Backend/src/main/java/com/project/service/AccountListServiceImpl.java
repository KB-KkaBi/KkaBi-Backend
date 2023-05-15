package com.project.service;

import java.util.List;

import com.project.domain.AccountList;
import com.project.repository.AccountListRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class AccountListServiceImpl implements AccountListService {
	

	private final AccountListRepository accountRep;
	
	private final JPAQueryFactory queryFactory;

	@Override
	public List<AccountList> selectAll() {
		return accountRep.findAll();
	}

	
}
