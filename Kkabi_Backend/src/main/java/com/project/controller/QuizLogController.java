package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.QuizLog;
import com.project.service.QuizLogService;

@RestController
public class QuizLogController {
	
	
	@Autowired
	private QuizLogService quizLogservice;
	
	
	/**
	 *  퀴즈 내역 조회 -> 전체 조회
	 *  @author seojisoosoo
	 */
	@GetMapping("/quiz-log")
	public List<QuizLog> selectQuizLog(int quizId){
		List<QuizLog> quizlogList=quizLogservice.selectQuizLog(quizId);
		
		return quizlogList;
	}
}
