package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.domain.AccountLog;

public interface AccountLogRepository extends JpaRepository<AccountLog, Integer>{
	
	@Query(value="select a from AccountLog a where a.accountList.accountId = :accountId")
	List<AccountLog> findAllByAccountListJPQL(@Param("accountId") int accountId);
}
