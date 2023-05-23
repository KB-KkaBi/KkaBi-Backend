package com.project;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.QuizInfo;
import com.project.domain.QuizLog;
import com.project.domain.TreasureInfo;
import com.project.domain.TreasureLog;
import com.project.domain.User;
import com.project.repository.QuizInfoRepository;
import com.project.repository.QuizLogRepository;
import com.project.repository.TreasureInfoRepository;
import com.project.repository.TreasureLogRepository;
import com.project.repository.UserRepository;

@SpringBootTest
@Transactional
@Commit
class JaehyunTest {

	@Autowired
	QuizInfoRepository quizInfoRep;

	@Autowired
	TreasureInfoRepository treasureInfoRep;

	@Autowired
	EntityManager entityManager;

	@Test
	void insertTreasureInfo() {
		treasureInfoRep.save(new TreasureInfo(1, "사파이", 0.03, 50));
		treasureInfoRep.save(new TreasureInfo(2, "반지", 0.05, 100));
		treasureInfoRep.save(new TreasureInfo(3, "왕관", 0.07, 200));
		treasureInfoRep.save(new TreasureInfo(4, "다이", 0.10, 300));
	}

	@Test
	void insertQuizInfo() {
		quizInfoRep.save(new QuizInfo(1, "주권에 대하여 주주가 가지는 권리 및 자본금 중의 출자지분을 나타내는 단어는?", "주식",
				"[ㅈ, ㄱ, ㄴ, ㄹ, ㅁ, ㅇ, ㅂ, ㄷ, ㅅ, ㅎ, ㅌ, ㅈ, ㅇ, ㅡ, ㄱ, ㅏ, ㅓ, ㅑ, ㅣ, ㅢ, ㅠ, ㅣ, ㅜ, ㅏ, ㅡ]", "ㅈ, ㅅ",
				treasureInfoRep.findByTreasureId(2)));
		quizInfoRep.save(new QuizInfo(2, "일정금액을 매월 일정기간 동안에 불입한 이후 약정계약 만료 이후에 금액 + 이자를 받는 예금 형식을 나타내는 단어는?", "적금",
				"[ㅈ, ㄱ, ㄴ, ㄹ, ㅁ, ㅇ, ㅂ, ㄷ, ㅅ, ㅎ, ㅌ, ㅈ, ㅇ, ㅡ, ㄱ, ㅏ, ㅓ, ㅑ, ㅣ, ㅢ, ㅠ, ㅣ, ㅜ, ㅏ, ㅡ]", "ㅈ, ㄱ",
				treasureInfoRep.findByTreasureId(3)));
	}

	@Test
	void getTreasureInfo() {
		List<TreasureInfo> treasureList = treasureInfoRep.findAll();
		for (TreasureInfo t : treasureList) {
			System.out.println(t.getTreasureName());
		}
	}

	@Test
	void getQuizInfoByTreasureId() {
		List<TreasureInfo> treasureList = treasureInfoRep.findAll();
		for (TreasureInfo t : treasureList) {
			int level = t.getTreasureId();
			List<QuizInfo> quizList = quizInfoRep.findAllByTreasureIdJPQL(level);
			for (QuizInfo q: quizList) {
				System.out.println("level " + q.getTreasureInfo().getTreasureId() + ": "+ q.getProblem());
			}
		}
	}
	
	@Autowired
	private QuizLogRepository quizLogRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private TreasureLogRepository treasureLogRep;
	
	@Test
	void checkQuizSuccessed() {
		int quiz_id = 1;
		int user_id = 1;
		int treasure_id = 1;
		int count = 100;
		String my_answer = "주식";
		User user = userRep.findById(user_id).orElseGet(null);
		TreasureInfo treasure = treasureInfoRep.findByTreasureId(treasure_id);
		LocalDateTime currentDateType = LocalDateTime.now();
		
		// 1. quiz_id, my_answer 둘만 가지고 정답 여부 조회하기		
		QuizInfo quiz = quizInfoRep.findByQuizId(1);
		System.out.println("퀴즈의 정답은: " + quiz.getAnswer());
		boolean successed = my_answer.equals(quiz.getAnswer());
		System.out.println("정답여부: " + successed);
		
		// 2. successed, user_id, quiz_id 로 quiz_log insert
		quizLogRep.save(new QuizLog(2, currentDateType, successed ? "T" : "F", user, quizInfoRep.findByQuizId(quiz_id)));
		
		// 3.successed, user_id, treasure_id, count 로 treasure_log insert
		treasureLogRep.save(new TreasureLog(1, currentDateType, count, user, treasure));
		
	}

	@Test
	void contextLoads() {
	}

}
