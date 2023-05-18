package com.project.dto;

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
public class AccoutListRequestDTO {
	private int accountInfoId;
	private String accountName;
	
	/**
	 * 나중에 지울것!
	 */
	private int userSeq;
	
	
}
