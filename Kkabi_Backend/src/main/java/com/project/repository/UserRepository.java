package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import com.project.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
		
	@Query("SELECT u FROM User u WHERE u.email = :email")
		User findByEmailJPQL(@Param("email") String email);
	

	/**
	 * 로그인 하기 위한 정보 검색
	 * */
	@Query(value="select u from User u where u.email = ?1")
	User signIn(String email);
	
}
	 

