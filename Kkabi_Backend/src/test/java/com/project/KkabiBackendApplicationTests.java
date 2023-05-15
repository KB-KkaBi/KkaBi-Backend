package com.project;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.project.domain.AccountList;
import com.project.repository.AccountListRepository;

@SpringBootTest
@Commit
@Transactional
class KkabiBackendApplicationTests {

	@Autowired
	private AccountListRepository accountRep;
	
	@Test
	void contextLoads() {
	}

	@Test
	void accountListInsert() {
		accountRep.save(new AccountList(1, "깨비 미래 적금", 날짜, status?, 유저))
		
		/*
		 * private int accountId;
	
	@Column(length = 20)
	private String accountName;
	
	private int accountMoney;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(length = 1)
	private String status;
	
	@JoinColumn(name="user_seq")
	@ManyToOne
	private User user;
	
	@JoinColumn(name="account_info_id")
	@ManyToOne
	private AccountInfo accountInfo;
		 */
	}
}
