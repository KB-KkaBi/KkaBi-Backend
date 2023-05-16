package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);
}
