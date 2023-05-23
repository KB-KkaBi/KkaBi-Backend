package com.project.service;

import java.util.List;


import com.project.domain.AccountInfo;
import com.project.domain.AccountList;

public interface AccountInfoService {
	  /**
	    * 전체검색
	    * */
	List <AccountInfo> selectAll();
	

}
