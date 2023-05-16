package com.project;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.project.domain.AccountInfo;
import com.project.repository.AccountInfoRepository;

@SpringBootTest
@Commit
@Transactional
class KkabiBackendApplicationTests {

	@Autowired
	private AccountInfoRepository accountInfoRep;
	
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
}

