package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
	/**
	 * 이메일 존재여부와 닉네임과
	 * 비밀번호 변경을 위한 이메일 찾기
	 * */
	@Query("SELECT u FROM User u WHERE u.email = :email")
		User findByEmailJPQL(@Param("email") String email);
	

	/**
	 * 로그인 하기 위한 정보 검색
	 * */
	@Query(value="select u from User u where u.email = ?1")
	User signIn(String email);
	

	
}
	 

