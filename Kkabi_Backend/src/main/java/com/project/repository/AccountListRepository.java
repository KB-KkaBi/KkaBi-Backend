package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.AccountList;

@Repository
public interface AccountListRepository extends JpaRepository<AccountList, Integer>{
	
	@Query(value="select a from AccountList a where a.user.userSeq = :userSeq")
	List<AccountList> findAccountListByUserSeq(@Param("userSeq") int userseq);
	
	@Query(value="update AccountList a "
			+ "set a.accountMoney = :accountLogMoney "
			+ "where a.accountId = :accountId")
	@Modifying
	void updateAccountMoney(@Param("accountLogMoney") int accountLogMoney, @Param("accountId") int accountId);
	
}
