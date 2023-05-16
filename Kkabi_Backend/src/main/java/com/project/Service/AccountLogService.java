package com.project.Service;

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
}
