package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.User;
import com.project.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;
	
	
	@Override
	public boolean isEmailExists(String email) {
		 User user = userRep.findByEmail(email);
		 
		 if(user != null) {
			 throw new RuntimeException("이미 존재하는 이메일입니다.");
		 }else {
			return false; 
		 }
		
	}


	@Override
	public User signUp(User user) {
		User users = userRep.save(user);
		return users;
	}
	
//	@Override
//	public void saveUser(User user) {
//		userRep.save(user);
//	}
}
