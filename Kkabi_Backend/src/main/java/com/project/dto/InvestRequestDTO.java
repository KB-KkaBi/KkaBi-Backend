package com.project.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "InvesController의 submit에 필요한 값을 받기 위한 DTO")
public class InvestRequestDTO {
	
	@ApiModelProperty(
			value = "퀴즈의 고유 id",
			example = "1",
			required = true)
	private int quizId;
	
	@ApiModelProperty(
			value = "보물의 고유 id",
			example = "2",
			required = true)
	private int treasureId;
	
	@ApiModelProperty(
			value = "투자한 보물의 개수",
			example = "100",
			required = true)
	private int count;
	
	@ApiModelProperty(
			value = "만든 정답",
			example = "주식",
			required = true)
	private String answer;
}
