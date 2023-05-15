package com.project.service;

import java.util.List;

import com.project.domain.AccountList;

public interface AccountListService {
	
	/** 
	 * 전체검색
	 */	
	List<AccountList> selectAll();

}
