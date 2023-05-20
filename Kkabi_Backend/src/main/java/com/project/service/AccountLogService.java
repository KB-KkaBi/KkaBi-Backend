package com.project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @return Page<AccountLog>
	 */
	Page<AccountLog> selectAccoungLog(int accountId, Pageable page);
}
