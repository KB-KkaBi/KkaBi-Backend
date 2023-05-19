package com.project.service;

import java.util.List;

import com.project.domain.QuizLog;

public interface QuizLogService {
	
	/**
	 * 내 로그 조회
	 * 
	 * @author seojisoosoo
	 * @return List<QuizLog>
	 */
	List<QuizLog> selectQuizLog(int userSeq);
	
}
