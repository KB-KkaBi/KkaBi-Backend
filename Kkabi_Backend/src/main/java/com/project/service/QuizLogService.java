package com.project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.domain.QuizLog;

public interface QuizLogService {
	
	/**
	 * 내 로그 조회
	 * 
	 * @author seojisoosoo
	 * @return List<QuizLog>
	 */
	Page<QuizLog> selectQuizLog(int userSeq, Pageable page);
}
