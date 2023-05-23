package com.project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.User;
import com.project.dto.DetailMoneyDTO;
import com.project.dto.DetailTreasureDTO;
import com.project.dto.UserResponseDTO;
import com.project.repository.AccountListRepository;
import com.project.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private AccountListService accountListService;
	
	@Autowired
	private TreasureLogService treasureLogService;
	
	/**
	 * 이메일 존재 여부 확인 
	 * */
	
	@Override
	public boolean isEmailExists(String email) {
		 User user = userRep.findByEmail(email);
		 
		 if(user != null) {
			 throw new RuntimeException("이미 존재하는 이메일입니다.");
		 }else {
			return false; 
		 }
		
	}
	
	/**
	 * 회원가입
	 * */

	@Override
	public User signUp(User user) {
		User users = userRep.save(user);
		return users;
	}
	
	/**
	 * 로그인
	 * @작성자 : 곽승규
	 * */
	@Override
	public User signIn(User user) {
		//아이디에 해당하는 회원정보를 조회한다
		User dbUser = userRep.signIn(user.getEmail());

		//조회된 결과가 null이면 throw new RuntimeException("");
		if(dbUser == null) {
			throw new RuntimeException("존재하지 않는 이메일로 로그인할 수 없습니다.");
		}
		//조회된결과가 있으면 비밀번호 일치확인 후 틀리면 throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		if(!dbUser.getPw().equals(user.getPw())) {
			throw new RuntimeException("비밀번호를 다시 확인해주세요.");
		}
		
		return dbUser;
	}
	

	/**
	 * 이메일 찾기
	 * */
	@Override
	public User findByEmail(String email) {
		return userRep.findByEmail(email);
	}
	
	
	/**
	 * 비밀번호 변경
	 * */
	@Override
	public void updatePw(User user, String currentPw, String newPw) throws Exception {
		if (!user.isValidPw(currentPw)) {
			throw new Exception("현재 비밀번호가 일치하지 않습니다.");
		}
		
		user.setPw(newPw);
		userRep.save(user);
		
	}
	
	
	/**
	 * 닉네임 변경 
	 * */
	@Override
	public void updateNickname(User user, String newNickname) {
		user.setNickname(newNickname);
		userRep.save(user);
		
	}

	@Override
	public UserResponseDTO findUserInfo(int userSeq) {
		
		User user = userRep.findById(userSeq).orElse(null);
		
		UserResponseDTO userInfo = new UserResponseDTO();
				
		// 준비물을 가지고 userInfo Setting
		userInfo.setCharacter(user.getCharacter());
		userInfo.setNickname(user.getNickname());
		userInfo.setDetailMoney(accountListService.findDetailMoney(userSeq));
		userInfo.setDetailTreasure(treasureLogService.findDetailTreasure(userSeq));
		
		return userInfo;
	}

}


