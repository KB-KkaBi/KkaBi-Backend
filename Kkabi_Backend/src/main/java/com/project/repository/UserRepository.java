package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
	
		
	@Query("SELECT u FROM User u WHERE u.email = :email")
		User findByEmailJPQL(@Param("email") String email);
}
	 

