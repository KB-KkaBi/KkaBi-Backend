package com.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.AccountList;
import com.project.domain.User;
import com.project.dto.AccoutListRequestDTO;
import com.project.service.AccountListService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class AccountListController {
	@Autowired
	private AccountListService accountListService;
	 
	@PostMapping("/create-account")
	public AccountList insert(@RequestBody AccoutListRequestDTO requestData, HttpSession session) {	
		
		AccountList accountList = new AccountList(requestData);
		
		accountList.setUser((User)session.getAttribute("loginUser"));
		
		AccountList accountlist=accountListService.insertNewAccount(accountList);
		
		return accountlist;
	}
	
	/**
	 * 내 모든 계좌 조회하기
	 * @author awarduuu
	 * @param sessoin
	 * @return
	 */
	@GetMapping("/get-account-all")
	@ApiOperation(value="내 모든 계좌 정보 조회", notes="나의 계좌 버튼 클릭 시 내 모든 계좌를 가져올 때 사용된다.")
	public List<AccountList> selectMyAccountList(@ApiIgnore HttpSession sessoin){
		
		User user = (User) sessoin.getAttribute("loginUser");
				
		List<AccountList> accountList = accountListService.selectMyAccountList(user.getUserSeq());
		
		return accountList;
		
	}
	
	/**
	 * 현재 작업중인 내 계좌 조회하기
	 * @author awarduuu
	 * @param accountId
	 * @return
	 */
	@GetMapping("/bank")
	@ApiOperation(value="작업 중인 계좌 정보 조회", notes="예금 or 출금 성공 시 띄우는 모달창을 확인 누를 시 "
			+ "은행 페이지로 넘어가면서 사용된다.")
	public AccountList selectCurrentMyAccount(@RequestParam int accountId) {
		
		AccountList accountList = accountListService.selectCurrentMyAccount(accountId);
		
		return accountList;
	}
	
	
}
