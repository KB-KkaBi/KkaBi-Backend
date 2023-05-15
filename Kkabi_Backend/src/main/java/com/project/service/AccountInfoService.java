package com.project.service;

import java.util.List;

import com.project.domain.AccountInfo;

public interface AccountInfoService {
	  /**
	    * 전체검색
	    * */
	List <AccountInfo> selectAll();

}
