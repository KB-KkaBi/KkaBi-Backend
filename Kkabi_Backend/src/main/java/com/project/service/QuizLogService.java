package com.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.domain.QuizLog;

public interface QuizLogService {
	
	/**
	 * 전체 검색 - 페이치 처리
	 */
	
	Page<QuizLog> selectAll(Pageable pageable);
	
}
