package com.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.QuizInfo;
import com.project.service.QuizInfoService;

@RestController
public class QuizInfoController {
	@Autowired
	private QuizInfoService quizInfoService;
		
	@GetMapping("/quiz-info")
	public List getQuizList(@RequestParam int level) {
		List<QuizInfo> list = quizInfoService.findByLev(level);
		return list;
	}
}
