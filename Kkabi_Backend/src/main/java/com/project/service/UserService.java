package com.project.service;

import com.project.domain.User;
import com.project.dto.UserInfoResponseDTO;

public interface UserService {
	User findByEmail(String email);
	
	/**
	 * 회원가입 및 이메일 존재 여부 확인
	 * */
	
	boolean isEmailExists(String email);
	User signUp(User user);

	/**
	 * 로그인하기
	 * @작성자 : 곽승규
	 * */
	User signIn(User user);


	
	/**
	 * 비밀번호 변경하기
	 * */
	
	void updatePw(User user, String currentPw, String newPw) throws Exception;
	
	/**
	 * 닉네임 변경하기
	 * */
	
	void updateNickname(User user, String newNickname);
	
	/**
	 * @author awarduuu
	 * 
	 * 메인페이지, 마이페이지에 랜딩될 때 유저 정보 제공
	 * 
	 * @param userSeq
	 * @return UserResponseDTO
	 */
	UserInfoResponseDTO findUserInfo(int userSeq);


}


