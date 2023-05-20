package com.project.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.domain.AccountLog;

public interface AccountLogRepository extends JpaRepository<AccountLog, Integer>{
	int nowPage = 1;
	int PAGE_COUNT = 10;
	Pageable page = PageRequest.of((nowPage-1), PAGE_COUNT);
	
	@Query(value="select a from AccountLog a where a.accountList.accountId = :accountId order by a.accountLogId desc")
	Page<AccountLog> findAllByAccountListJPQL(@Param("accountId") int accountId, Pageable page);
}
