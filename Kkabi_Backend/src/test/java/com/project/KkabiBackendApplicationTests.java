package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.domain.User;
import com.project.repository.UserRepository;

@SpringBootTest
class KkabiBackendApplicationTests {

	@Autowired
	private UserRepository userRep;
	
	@Test
	void contextLoads() {
		
		userRep.save(User.builder()
				.character("루나키키")
				.email("tmdrb0912@naver.com")
				.pw("1234")
				.nickname("승구")
				.build());
	}

}
