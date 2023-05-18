package com.project.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.domain.QuizLog;
import com.project.repository.QuizLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class QuizLogServiceImpl implements QuizLogService {
	private final QuizLogRepository quizRep;
	
	@Override
	public Page<QuizLog> selectAll(Pageable pageable) {
		return quizRep.findAll(pageable);
	}

}
