package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.domain.AccountList;

@Repository
public interface AccountListRepository extends JpaRepository<AccountList, Integer>{

}
