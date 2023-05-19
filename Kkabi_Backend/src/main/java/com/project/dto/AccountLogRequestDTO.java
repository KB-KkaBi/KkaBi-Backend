package com.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author awarduuu
 *
 */
@Getter
@Setter
@ToString
@ApiModel(description = "AccountLogController의 insertAccountLog에서 entity를 매핑하기 위한 DTO")
public class AccountLogRequestDTO {
	
	@ApiModelProperty(
			value = "transaction 후 계좌 잔액"
			,example = "13000"
			,required = true)
    private int accountLogMoney;
	
	@ApiModelProperty(
			value = "transaction 타입(입금, 출금, 이자)"
			,example = "입금"
			,required = true)
    private String transactionType;
	
	@ApiModelProperty(
			value = "transaction 이유"
			,example = "용돈"
			,required = true)
    private String transactionReason;
	
	@ApiModelProperty(
			value = "transaction 금액"
			,example = "2000"
			,required = true)
    private int transactionAmount;
    
	@ApiModelProperty(
			value = "계좌 고유 id"
			,example = "1"
			,required = true)
    private int accountId;

}
