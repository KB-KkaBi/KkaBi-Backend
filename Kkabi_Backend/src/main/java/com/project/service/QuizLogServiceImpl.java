package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.QuizLog;
import com.project.repository.QuizLogRepository;

@Service
@Transactional
public class QuizLogServiceImpl implements QuizLogService {

	@Autowired
	private QuizLogRepository quizLogRep;
	
	@Override
	public List<QuizLog> selectQuizLog(int userSeq) {
		List<QuizLog> quizLogList=quizLogRep.findAllQuizLog(userSeq);
		
		return quizLogList;
	}

}
