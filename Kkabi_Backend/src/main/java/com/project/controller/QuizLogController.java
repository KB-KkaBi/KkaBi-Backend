package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.QuizLog;
import com.project.domain.User;
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
	public Page<QuizLog> selectQuizLog(HttpSession session,Model model, Pageable page){
		User user=(User) session.getAttribute("loginUser");
		
		Page<QuizLog> quizlogList=quizLogservice.selectQuizLog(user.getUserSeq(), page);
		
		
		model.addAttribute("quizlogList", quizlogList);
		
		return quizlogList;
	}
	
}
