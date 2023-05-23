package com.project.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.User;
import com.project.dto.UserLoginRequestDto;
import com.project.dto.PasswordRequestDTO;
import com.project.dto.UserInfoResponseDTO;
import com.project.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class UserController {


@Autowired
private UserService userService;

	/**
	 * 회원가입 요청 처리(POST)
	 * */

	@PostMapping("/register")
	public Object signUp(@RequestBody User user, BindingResult bindingResult) {

		//우선 이메일이 현재 db에 있는지 체크를 한다.
		
		//이메일 중복 검사
		User dbUser = null;
		if (!userService.isEmailExists(user.getEmail())) {
			
			dbUser = userService.signUp(user);
			
		}
		
		//response할 객체 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", dbUser);
//		map.put("message", "회원가입 성공");
		
		return map;
	}
	
	@PostMapping("/check-email")
	public Map<String, String> checkEmail(@RequestParam String email){
		
		Map<String, String> response = new HashMap<String, String>();
			
		if(!userService.isEmailExists(email)) {

			response.put("message", "중복되지 않는 이메일입니다.");

		}
			
		return response;
	}
	
	/**
	 * 패스워드 변경하기
	 *
	 * */
	@PostMapping("/update-password") 
	public Map<String, String> updatePassword( 
			HttpSession session,
			@RequestBody PasswordRequestDTO request
	) throws Exception{
		Map<String, String> response = new HashMap<String, String>();
		//이메일을 session에서 확인
		User user  =(User) session.getAttribute("loginUser");
		User dbUser = userService.findByEmail(user.getEmail());			
		userService.updatePw(dbUser, request.getCurrentPw(), request.getNewPw());


		response.put("message", "비밀번호 변경이 완료되었습니다.");
		
		
		return response;
	}
	
	
	/** 
	 * 닉네임 변경하기
	 * */
	@PostMapping("/update-nickname") 
	public Map<String, String> updateNickname( 
			HttpSession session,
			@RequestParam("newNickname") String newNickname
	) {
		//MAP 생성
		Map<String, String> response = new HashMap<>();
		
		//이메일을 session에서 확인
		User user = (User) session.getAttribute("loginUser");
		User dbUser = userService.findByEmail(user.getEmail());
		userService.updateNickname(dbUser, newNickname);
		
		response.put("message", "닉네임 변경이 완료되었습니다.");
		
		return response;
	}
	
	
	/**
	 * 로그인하기
	 * @params : email, pw
	 * 
	 * */
	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "사용자 로그인할때 사용된다.") //method에 대한 설명을 추가
	public Object signIn(@RequestBody UserLoginRequestDto user, HttpSession session) {
		
		
		User loginUser = new User(user);
		User dbUser = userService.signIn(loginUser);
		
		
		//HttpSession에 정보를 저장한다.
		dbUser.setPw(null);

		session.setAttribute("loginUser", dbUser);
		
		//보내줄 유저정보 다시 세팅
		HashMap<String, Object> users = new LinkedHashMap<String, Object>();
		users.put("userSeq", dbUser.getUserSeq());
		users.put("nickname", dbUser.getNickname());
		users.put("character", dbUser.getCharacter());


		//response할 객체 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", users);

		
		return map;
	}


	
	/**
	 * 로그아웃하기
	 **/
	@ApiOperation(value = "로그아웃", notes = "사용자 로그아웃할 때 사용된다.")
	@PostMapping("/logout")
	public Object logout(@ApiIgnore HttpSession session) {
	
		//그냥 세션에서 값 있는지 확인
		User user = (User)session.getAttribute("loginUser");
		//User dbUser = userService.logout(user.getUserSeq());
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		//모든 세션의 정보를 삭제한다.
		if (user != null) {
			session.invalidate();
			maps.put("message", "로그아웃 성공");
		}else {
			throw new RuntimeException("로그아웃 실패");
		}
		
		return maps;
	}
	
	@ApiOperation(value = "유저 정보 불러오기", notes = "메인페이지, 마이페이지 랜딩될 때 사용된다.")
	@GetMapping("/userInfo")
	public UserInfoResponseDTO getUserInfo(HttpSession session) {
		
		User user = (User)session.getAttribute("loginUser");
		
		UserInfoResponseDTO userInfo = userService.findUserInfo(user.getUserSeq());
		
		return userInfo;
	}

}
