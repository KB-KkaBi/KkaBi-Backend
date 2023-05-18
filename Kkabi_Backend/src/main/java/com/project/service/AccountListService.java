package com.project.service;

import java.util.List;

import com.project.domain.AccountList;
import com.project.dto.AccoutListRequestDTO;

public interface AccountListService {
	 AccountList insertNewAccount(AccountList accountList);
	 List<AccountList> selectMyAccountList(int userSeq);
}
