package com.project;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.User;
import com.project.repository.AccountInfoRepository;
import com.project.repository.AccountListRepository;

@SpringBootTest
@Commit
@Transactional
class KkabiBackendApplicationTests {

	@Autowired
	private AccountInfoRepository accountInfoRep;
	
	@Autowired
	private AccountListRepository accountListRep;
	
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
		AccountList list = AccountList.builder().accountName("감자").accountMoney(0).status("1").user(user).accountInfo(info).build();
		entityManager.persist(list);
		accountListRep.save(list);
	}

	
}

