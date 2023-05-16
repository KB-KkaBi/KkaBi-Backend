package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.User;
import com.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRep;

	@Override
	public User loginCheck(User user) throws UsernameNotFoundException {
		User users = userRep.findByEmail(user.getEmail()).orElse(null);
		if (users == null) {
			System.out.println("안됨!");
			throw new UsernameNotFoundException(String.format("No user found with userEmail '%s'.", user.getEmail()));
		}else {
			return users;
		}
	}
	
	
}
