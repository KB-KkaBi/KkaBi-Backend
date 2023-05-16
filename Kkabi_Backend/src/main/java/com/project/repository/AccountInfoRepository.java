package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.AccountInfo;

public interface AccountInfoRepository  extends JpaRepository<AccountInfo, Integer>{

}
