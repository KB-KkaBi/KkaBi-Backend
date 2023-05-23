package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.domain.User;
import com.project.dto.AccoutListRequestDTO;
import com.project.dto.DetailMoneyDTO;
import com.project.repository.AccountListRepository;
import com.project.repository.TreasureLogRepository;

import java.util.List;

import javax.persistence.EntityManager;

@Service
@Transactional
public class AccountListServiceImpl implements AccountListService {

	@Autowired
	private AccountListRepository accountListRep;
	
	@Autowired
	private TreasureLogRepository treasureLogRep;
	
	@Override
	public AccountList insertNewAccount(AccountList accountList) {		

		AccountList accountListNew=accountListRep.save(accountList);
		                           
		return accountListNew;
	}

	@Override
	public List<AccountList> selectMyAccountList(int userSeq) {
		
		List<AccountList> myAccountList = accountListRep.findAccountListByUserSeq(userSeq);
		
		return myAccountList;
	}

	@Override
	public AccountList selectCurrentMyAccount(int accountId) {
		
		AccountList currentAccount = accountListRep.findById(accountId).orElse(null);
		
		if(currentAccount == null) {
			 throw new RuntimeException("현재 계좌가 존재하지 않습니다.^^");
		 }
		
		return currentAccount;
	}

	@Override
	public boolean checkMyAccountMoney(int accountId, int tranactionAmount) {
		if(tranactionAmount > accountListRep.findById(accountId).orElse(null).getAccountMoney()) {
			return false;
		}
		return true;
	}

	@Override
	public DetailMoneyDTO findDetailMoney(int userSeq) {
		DetailMoneyDTO detailMoney = new DetailMoneyDTO();
		
		int totalDeposit = accountListRep.selectSumOfMyDepositJPQL(userSeq)==null?0:
			accountListRep.selectSumOfMyDepositJPQL(userSeq);
		
		int totalSavings = accountListRep.selectSumOfMySavingsJPQL(userSeq)==null?0:
			accountListRep.selectSumOfMySavingsJPQL(userSeq);
		
		int totalTreasure = treasureLogRep.selectSumOfMyTreausreJPQL(userSeq)==null?0:
			treasureLogRep.selectSumOfMyTreausreJPQL(userSeq);
		
		detailMoney.setTotalDeposit(totalDeposit);
		detailMoney.setTotalSavings(totalSavings);
		detailMoney.setTotalTreasure(totalTreasure);
		
		return detailMoney;
	}

}
