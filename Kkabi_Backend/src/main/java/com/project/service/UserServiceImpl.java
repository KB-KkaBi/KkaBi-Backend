package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.User;
import com.project.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRep;
	
	@Override
	public User signIn(User user) {
		//아이디에 해당하는 회원정보를 조회한다
		User dbUser = userRep.signIn(user.getEmail());

		//조회된 결과가 null이면 throw new RuntimeException("");
		if(dbUser == null) {
			throw new RuntimeException("존재하지 않는 이메일로 로그인할 수 없습니다.");
		}
		//조회된결과가 있으면 비밀번호 일치확인 후 틀리면 throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		if(!dbUser.getPw().equals(user.getPw())) {
			throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		}
		return dbUser;
	}

}
