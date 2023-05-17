package com.project;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.project.domain.User;
import com.project.repository.UserRepository;

@SpringBootTest
@Commit
@Transactional
class Step32UserApplicationTests {
	
	@Autowired
	private UserRepository userRep;
	

	@Test
	void contextLoads() {
				
		  userRep.save(
				   User.builder()
				  .email("abc@naver.com")
				  .pw("1234")
				  .nickname("쿵야")
				  .character("치라차차")
				  .build()
				  );
		}
	
	@Test
    public void testFindByEmailJPQL() {
        // 가상의 이메일과 사용자 생성
        String email = "abc@naver.com";
        User user = User.builder()
                	.email(email)
                	.pw("1234")
                	.nickname("쿵야")
                	.character("치라차차")
                	.build();
	
	}
	
}






