package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //final 기반으로 주입해주는 거임
public class UserController {

	@Autowired
	private final UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> userSignIn(@RequestBody String email, String pw) {

		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  User userInfo = User.builder() // 빌더어노테이션으로 생성된 빌더클래스 생성자
				    .email(email)
				    .pw(pw)
				    .build();
		  System.out.println(userInfo);
		  User loginUser = userService.loginCheck(userInfo);
		  if(loginUser == null) {
		    resultMap.put("message", "로그인실패");
		    resultMap.put("success", "false");
		  }else {
		    //resultMap.put("token", loginUser);
		    resultMap.put("message", "로그인성공");
		    resultMap.put("success", "true");
		  }
		  
		  return new ResponseEntity<>(resultMap, HttpStatus.OK);
		}
	
}
