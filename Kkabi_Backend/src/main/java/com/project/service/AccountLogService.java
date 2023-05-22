package com.project.service;

import java.util.List;

import com.project.domain.AccountLog;

public interface AccountLogService {
	/**
	 * 로그 기록
	 * 
	 * @author awarduuu
	 * @param accountLog
	 * @return AccountLog
	 */
	AccountLog insertAccountLog(AccountLog accountLog);
	
	/**
	 * 내 로그 조회
	 * 
	 * @author awarduuu
	 * @param accountId
	 * @return List<AccountLog>
	 */
	List<AccountLog> selectAccoungLog(int accountId);
	
	/**
	 * 매일 00시에 확인하여 적금 만기 시 로그 기록
	 * 
	 * @author awarduuu
	 * 
	 */
	void insertAccountLogForInterest();
}
