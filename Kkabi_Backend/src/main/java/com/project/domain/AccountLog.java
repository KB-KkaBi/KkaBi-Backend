package com.project.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.project.dto.AccountLogRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "account_log")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_log_gen")
	@SequenceGenerator(name = "account_log_gen", allocationSize = 1, sequenceName = "account_log_gen")
	private int accountLogId;
	
	@CreationTimestamp
	private LocalDateTime accountLogDate;
	
	private int accountLogMoney;
	
	@Column(length = 20)
	private String transactionType;
	
	@Column(length = 50)
	private String transactionReason;
	
	private int transactionAmount;
	
	@JoinColumn(name="account_id")
	@ManyToOne
	private AccountList accountList;
	
	/**
	 * AccountLogReqeust에서 옮길 생성자
	 */
	
	public AccountLog(AccountLogRequestDTO request) {
		this.accountLogMoney = request.getAccountLogMoney();
		this.transactionType = request.getTransactionType();
		this.transactionReason = request.getTransactionReason();
		this.transactionAmount = request.getTransactionAmount();
		this.accountList = new AccountList(request.getAccountId());
	}

}
