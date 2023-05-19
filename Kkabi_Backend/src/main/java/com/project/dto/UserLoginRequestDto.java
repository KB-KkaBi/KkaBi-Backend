package com.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@ApiModel(description = "이메일, 비밀번호를 가진 로그인을 위한 DTO")
public class UserLoginRequestDto {
	
	@ApiModelProperty(
		value = "사용자 이메일"
		,example = "abc@naver.com"
		,required = true
	)
	private String email;
	
	
	@ApiModelProperty(
			value = "사용자 비밀번호"
			,example = "kb1234"
			,required = true
		)
	private String pw;
}
