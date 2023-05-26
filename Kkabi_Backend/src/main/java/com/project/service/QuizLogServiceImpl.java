package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.domain.QuizLog;
import com.project.repository.QuizLogRepository;

@Service
@Transactional
public class QuizLogServiceImpl implements QuizLogService {

	@Autowired
	private QuizLogRepository quizLogRep;

	@Override
	public Page<QuizLog> selectQuizLog(int userSeq, Pageable page) {
		Page<QuizLog> quizLogList=quizLogRep.findAllQuizLog(userSeq, page);
		
		return quizLogList;
	}

	@Override
	public List<QuizLog> selectTotalQuizLog(int userSeq){
		List<QuizLog> quizLogList=quizLogRep.findTotalQuizLog(userSeq);
		return quizLogList;
	}
	
}
