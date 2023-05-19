package com.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Commit;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.QuizInfo;
import com.project.domain.QuizLog;
import com.project.domain.TreasureInfo;
import com.project.domain.User;
import com.project.repository.AccountInfoRepository;
import com.project.repository.AccountListRepository;
import com.project.repository.QuizInfoRepository;
import com.project.repository.QuizLogRepository;
import com.project.repository.TreasureInfoRepository;
import com.project.repository.UserRepository;
import com.project.service.QuizLogService;

@SpringBootTest
@Commit
@Transactional
class KkabiBackendApplicationTests {

	@Autowired
	private AccountInfoRepository accountInfoRep;

	@Autowired
	private AccountListRepository accountListRep;

	@Autowired
	private QuizLogService quizLogService;

	@Autowired
	private QuizLogRepository quizLogRepository;

	@Autowired
	private QuizInfoRepository quizInfoRepository;

	@Autowired
	private TreasureInfoRepository treasureInfoRep;
	
	@Autowired
	private UserRepository userRep;

	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {

	}

	@Test
	void accountInfoInsert() {
		accountInfoRep.save(new AccountInfo(1, "깨비 미래 적금", 10.0, "12일 만기, 이자율 10%"));
		accountInfoRep.save(new AccountInfo(2, "깨비 young 적금", 5.0, "6일 만기, 이자율 5%"));
		accountInfoRep.save(new AccountInfo(3, "깨비 자유로운 예금", 0.0, "매일 100원 지급, 예금 한도 하루 5만원"));
		accountInfoRep.save(new AccountInfo(4, "깨비 super young 예금", 0.0, "매일 500원 지급, 예금 한도 하루 1만원"));

	}

	@Test
	void accountListInsert() {
		User user = User.builder().email("soosoo@naver.com").pw("1234").character("루나키키").nickname("헬로우").build();
		entityManager.persist(user);
		AccountInfo info = AccountInfo.builder().accountType("적금").interestRate(0.07).information("좋은 적금").build();
		entityManager.persist(info);
		AccountList list = AccountList.builder().accountName("감자").accountMoney(0).status("1").user(user)
				.accountInfo(info).build();
		entityManager.persist(list);
		accountListRep.save(list);
	}

	@Test
	void quizlogGet() {
	//	List<QuizLog> quizLogs=quizLogRepository.findAllQuizLog();
		TreasureInfo treasure=treasureInfoRep.save(TreasureInfo.builder().treasureName("보물1").interestRate(1.0).price(100).build());
	
		
			
////    	userSeq -> 퀴즈 로그  
		User user = userRep.save(User.builder().email("soosoo@naver.com").pw("1234").character("루나키키").nickname("헬로우").build());
//		entityManager.persist(user);
//
    //	퀴즈 로그 -> 퀴즈 인포
		for (int i = 1; i <= 30; i++) {
			QuizInfo quizInfo = quizInfoRepository
					.save(QuizInfo.builder().problem("문제" + i).answer("정답" + i).array("배열" + i).treasureInfo(treasure).build());
		}
		
//		QuizInfo quizInfo = quizInfoRepository
//				.save(QuizInfo.builder().problem("문제").answer("정답").array("배열").treasureInfo(treasure).build());

		
		for(int j=1;j<=20;j++) {
			QuizLog quizLog=quizLogRepository.save(QuizLog.builder().success("1")
					.quizInfo(quizInfoRepository.findById(j).orElse(null))
						.user(user).build());
		}
		
//		List<QuizLog> quizLogs= quizLogRepository.findAllQuizLog(1);
		
		Pageable page = PageRequest.of(1, 5);
		Page<QuizLog> quizLogs= quizLogRepository.findAllQuizLog(1, page);
//		Page<QuizLog> findAllQuizLog(1, Pageable pageable);
		
		for(QuizLog q : quizLogs) {
			System.out.println(q);
		}
//
//
////	퀴즈 인포 -> treasure 난이도
//		treasureInfoRep.save(new TreasureInfo(1, "보물1", 1.0, 100));
//		treasureInfoRep.save(new TreasureInfo(2, "보물2", 3.0, 300));
//		treasureInfoRep.save(new TreasureInfo(3, "보물3", 5.0, 500));
//		treasureInfoRep.save(new TreasureInfo(4, "보물4", 7.0, 700));
//		entityManager.persist(treasureInfo);
//		
//		
//		for (int i = 1; i <= 30; i++) {
//			QuizLog quizLog=quizLogRepository
//					.save(QuizLog.builder().quizLogId(i).success("1").user(user).quizInfo(quizInfo).build());
//			quizLogRepository.save(quizLog);
//		}
//
//		
		
		
	}
}
