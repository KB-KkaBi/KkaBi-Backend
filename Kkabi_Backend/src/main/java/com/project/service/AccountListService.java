package com.project.service;

import java.util.List;

import com.project.domain.AccountList;
import com.project.dto.DetailMoneyDTO;

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
	 
	 /**
	  * 내 계좌 잔액을 체크하여 출금할 수 있을지 확인하는 메소드
	  * @author awarduuu
	  * @param accountList
	  * @return 사용할 돈이 잔액보다 많으면 false, 아니면 true
	  */
	 boolean checkMyAccountMoney(int accoundId, int transactionAmount);
	 
	 DetailMoneyDTO findDetailMoney(int userSeq);
}
