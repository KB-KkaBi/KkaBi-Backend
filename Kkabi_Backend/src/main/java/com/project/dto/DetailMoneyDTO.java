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

public class DetailMoneyDTO {

	private int totalDeposit;
	
	private int totalSavings;
	
	private int totalTreasure;
	
}
