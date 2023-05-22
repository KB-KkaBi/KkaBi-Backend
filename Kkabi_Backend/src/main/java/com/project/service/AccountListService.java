package com.project.service;

import java.util.List;

import com.project.domain.AccountList;

public interface AccountListService {
	 AccountList insertNewAccount(AccountList accountList);
	 
	 /**
	  * 내가 가진 모든 계좌 조회하는 메소드
	  * 
 	  * @author awarduuu
	  * @param userSeq
	  * @return List<AccountList>
	  */
	 List<AccountList> selectMyAccountList(int userSeq);
	 
	 /**
	  * 현재 작업하고 있는 내 계좌 정보 조회
	  * 
	  * @author awarduuu
	  * @param accountId
	  * @return AccountList
	  */
	 AccountList selectCurrentMyAccount(int accountId);
	 
}
