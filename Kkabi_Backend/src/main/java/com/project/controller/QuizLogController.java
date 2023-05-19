package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.QuizLogService;

@RestController
public class QuizLogController {
	
	
	@Autowired
	private QuizLogService quizLogservice;
	
	
	/**
	 *  전체 검색 페이지
	 */
	@GetMapping("/quiz-log")
	public void quizLog();
}
