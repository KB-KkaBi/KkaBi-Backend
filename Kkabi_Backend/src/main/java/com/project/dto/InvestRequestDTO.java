package com.project.dto;

import java.time.LocalDateTime;

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
public class InvestRequestDTO {
	private int quizId;
	private int treasureId;
	private int count;
	private String answer;
	
	/**
	 * TODO: 제거해야 할 코드
	 */
	private int userSeq;
}
