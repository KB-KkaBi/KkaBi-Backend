package com.project.service;

import java.util.List;

import com.project.domain.QuizInfo;

public interface QuizInfoService {
	/**
	 * 퀴즈 전체 조회
	 * */
	List<QuizInfo> selectAll();
	
	/**
	 * 퀴즈 레벨로 검색
	 * */
	List<QuizInfo> findByLev(int level);
}
