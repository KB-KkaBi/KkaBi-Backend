package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.domain.QuizInfo;
import com.project.repository.QuizInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class QuizInfoServiceImpl implements QuizInfoService {

	private final QuizInfoRepository quizInfoRep;

	@Override
	public List<QuizInfo> selectAll() {
		return quizInfoRep.findAll();
	}

	@Override
	public List<QuizInfo> findByTreasureId(int treasureId) {
		return quizInfoRep.findAllByTreasureIdJPQL(treasureId);
	}

}
