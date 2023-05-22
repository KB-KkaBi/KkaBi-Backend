package com.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.dto.UserLoginRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", allocationSize = 1, sequenceName = "user_seq_gen")
	private int userSeq;
	
	@Column(unique = true, length = 25)
	private String email;
	
	@Column(length = 25)
	private String pw;
	
	@Column(length = 30)
	private String nickname;
	
	@Column(length = 50, name="characters")
	private String character;
	
	/**
	 * user로 접근하기 위한 생성자
	 * 
	 * @param userSeq
	 */
	public User(int userSeq) {
		this.userSeq = userSeq;
	}
	
	public User(UserLoginRequestDto userDto) {
		this.email = userDto.getEmail();
		this.pw = userDto.getPw();
	}
	
	/**
	 * 비밀번호 유효성 검사 메서드
	 * */
	
	public boolean isValidPw(String pw) {
		return this.pw.equals(pw);
	}
}
