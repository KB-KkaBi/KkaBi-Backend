package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.domain.AccountInfo;
import com.project.domain.AccountList;
import com.project.repository.AccountInfoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class AccountInfoServiceImpl implements AccountInfoService {
	
	private final AccountInfoRepository accountInfoRep;

	@Override
	public List<AccountInfo> selectAll() {
		return accountInfoRep.findAll();
	}
	

}
