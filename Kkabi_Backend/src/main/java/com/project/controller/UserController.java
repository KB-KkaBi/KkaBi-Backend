package com.project.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.User;
import com.project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;


	//회원가입 요청 처리(POST)
	@PostMapping("/register")
	public Object signUp(@RequestBody User user, BindingResult bindingResult) {

		//우선 이메일이 현재 db에 있는지 체크를 한다.
		//이메일 중복 검사
		User dbUser = null;
		if (!userService.isEmailExists(user.getEmail())) {
			
			dbUser = userService.signUp(user);
			
		}
		
		//보내줄 유저정보 다시 세팅
		HashMap<String, Object> users = new LinkedHashMap<String, Object>();
		users.put("userSeq", dbUser.getUserSeq());
		users.put("nickname", dbUser.getNickname());
		users.put("character", dbUser.getCharacter());

		//response할 객체 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", users);
//		map.put("message", "회원가입 성공");
		
		return map;
	}

	



		


}
