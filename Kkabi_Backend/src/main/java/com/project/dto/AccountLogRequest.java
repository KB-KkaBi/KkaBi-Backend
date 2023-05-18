package com.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * AccountLogController의 insertAccountLog에서 entity를 매핑하기 위한 dto
 * @author awarduuu
 *
 */
@Getter
@Setter
@ToString
public class AccountLogRequest {
	
    private int accountLogMoney;
    private String transactionType;
    private String transactionReason;
    private int transactionAmount;
    
    private int accountId;

}
