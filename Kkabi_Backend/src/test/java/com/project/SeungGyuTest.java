package com.project;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.domain.User;
import com.project.repository.AccountLogRepository;
import com.project.repository.UserRepository;
import com.project.service.UserService;

@SpringBootTest
@Transactional
@Commit
class SeungGyuTest {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EntityManager entityManager;
	
	
	@Test
	void signIn() {
		User user = User.builder() // 빌더어노테이션으로 생성된 빌더클래스 생성자
			   .email("tmdrb0912@naver.com")
			   .pw("1234")
			   .build();
		
		User dbuser = userService.signIn(user);
		System.out.println(dbuser);
	}
	
	@Test
	void userInsert() {
		User user = User.builder()
				.email("tmdrb0912@naver.com")
				.pw("1234")
				.character("깨비")
				.nickname("승구")
				.build();
		userRep.save(user);
	}
//	void accountLogInsert() {
//		User user = User.builder().email("award_uuu@naver.com").pw("1234").character("깨비").nickname("어월두").build();
//		entityManager.persist(user);
//		AccountInfo info = AccountInfo.builder().accountType("적금").interestRate(0.07).information("좋은 적금").build();
//		entityManager.persist(info);
//		AccountList list = AccountList.builder().accountName("이름").accountMoney(10000).status("1").user(user).accountInfo(info).build();
//		entityManager.persist(list);
//		accountLogRep.save(AccountLog.builder().accountLogMoney(10000).transactionAmount(-1000).transactionReason("과자")
//				.transactionType("1").accountListById(list).build());
//	}
	
	
	@Test
	void logout() { 
		
	}
	@Test
	void contextLoads() {
	}

}
