package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.domain.AccountInfo;

@Repository
public interface AccountInfoRepository  extends JpaRepository<AccountInfo, Integer>{

}
