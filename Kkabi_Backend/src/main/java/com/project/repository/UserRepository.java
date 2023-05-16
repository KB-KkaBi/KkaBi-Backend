package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	/**
	 * 로그인 하기 위한 정보 검색
	 * */
	@Query(value="select u from User u where u.email = ?1")
	User signIn(String email);
	
}
