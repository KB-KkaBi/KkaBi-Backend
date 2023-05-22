package com.project;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.domain.AccountLog;
import com.project.domain.QuizLog;
import com.project.domain.User;
import com.project.repository.AccountInfoRepository;
import com.project.repository.AccountListRepository;
import com.project.repository.AccountLogRepository;
import com.project.repository.UserRepository;

@SpringBootTest
@Transactional
@Commit
class SangwooTest {
	
	@Autowired
	AccountLogRepository accountLogRep;
	
	@Autowired
	AccountInfoRepository accountInfoRep;
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	AccountListRepository accountListRep;
	
	@Autowired
	EntityManager entityManager;
	
	
	@Test
	void accountLogInsert() {
		User user = User.builder().email("awar_uu6@naver.com").pw("12345").character("깨비1").nickname("어월두2").build();
		entityManager.persist(user);
		AccountInfo info = AccountInfo.builder().accountType("적금").interestRate(0.07).information("좋은 적금").build();
		entityManager.persist(info);
		AccountList list = AccountList.builder().accountName("이름").accountMoney(10000).status("1").user(user).accountInfo(info).build();
		entityManager.persist(list);
		
//		AccountInfo info1 = AccountInfo.builder().accountType("예금").interestRate(0.02).information("나쁜 예금").build();
//		entityManager.persist(info1);
//		AccountList list1 = AccountList.builder().accountName("이름3").accountMoney(20000).status("1").user(user).accountInfo(info1).build();
//		entityManager.persist(list1);
		
		accountLogRep.save(AccountLog.builder().accountLogMoney(10000).transactionAmount(-1000).transactionReason("과자")
				.transactionType("1").accountList(list).build());
	}
	
	
	@Test
	void accountLogSelect() {
		for(int j=1;j<=20;j++) {
			accountLogRep.save(AccountLog.builder().accountLogMoney(10000)
					.accountList(accountListRep.findById(1).orElse(null))
					.transactionAmount(-1000)
					.transactionReason("과자")
					.transactionType("1").build());
		}		
		
//		Pageable page = PageRequest.of(1, 10);
//		Page<AccountLog> logList = accountLogRep.findAllByAccountListJPQL(1, page);
		
	}
	
	@Test
	void accountListSelect() {
		
		
		accountListRep.save(AccountList.builder().accountInfo(accountInfoRep.findById(1).orElse(null))
				.accountMoney(0)
				.accountName("깨비즈")
				.user(userRep.findById(1).orElse(null)).build());
		
		List<AccountList> accountList = accountListRep.findAccountListByUserSeq(1);
		
		for(AccountList l : accountList) {
			System.out.println(l);
		}
	}

	@Test
	void contextLoads() {
	}

}
