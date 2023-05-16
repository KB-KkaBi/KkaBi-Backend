package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.AccountLog;

public interface AccountLogRepository extends JpaRepository<AccountLog, Integer>{
	
}
