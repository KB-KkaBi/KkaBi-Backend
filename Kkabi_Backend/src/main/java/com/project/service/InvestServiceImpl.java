package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.AccountLog;
import com.project.domain.InvestResult;
import com.project.domain.QuizInfo;
import com.project.domain.QuizLog;
import com.project.domain.TreasureInfo;
import com.project.domain.TreasureLog;
import com.project.domain.User;
import com.project.dto.InvestRequestDTO;
import com.project.repository.AccountListRepository;
import com.project.repository.AccountLogRepository;
import com.project.repository.QuizInfoRepository;
import com.project.repository.QuizLogRepository;
import com.project.repository.TreasureInfoRepository;
import com.project.repository.TreasureLogRepository;
import com.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class InvestServiceImpl implements InvestService {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private QuizInfoRepository quizInfoRep;
	@Autowired
	private TreasureInfoRepository treasureInfoRep;

	@Autowired
	private AccountListRepository accountListRep;

	@Autowired
	private QuizLogRepository quizLogRep;
	@Autowired
	private TreasureLogRepository treasureLogRep;
	@Autowired
	private AccountLogRepository accountLogRep;

	@Override
	public InvestResult submit(InvestRequestDTO request) {
		
		// 1. quiz_id, my_answer 둘만 가지고 정답 여부 조회하기
		QuizInfo quiz = quizInfoRep.findByQuizId(request.getQuizId());
		boolean successed = request.getAnswer().equals(quiz.getAnswer());
		
		// TODO: session에서 받아오는걸로 수정
		User user = userRep.findById(request.getUserSeq()).orElseGet(null);

		TreasureInfo treasure = treasureInfoRep.findByTreasureId(request.getTreasureId());

		// 2. successed, user_id, quiz_id 로 quiz_log 생성
		QuizLog quizLog = new QuizLog(successed ? "T" : "F", user, quiz);
		quizLogRep.save(quizLog);

		// 3. successed, user_id, treasure_id, count 로 treasure_log insert
		int treasureTotal = (int) ((request.getCount()) * (1 + ((successed ? 1 : -1) * treasure.getInterestRate())));
		TreasureLog treasureLog = new TreasureLog(treasureTotal, user, treasure);
		treasureLogRep.save(treasureLog);

		// TODO: 4. account log 생성 필요

		return new InvestResult(successed, treasureTotal);
	}

}
