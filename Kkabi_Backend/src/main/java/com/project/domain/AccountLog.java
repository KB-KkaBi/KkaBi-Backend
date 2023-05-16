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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account_log")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_log_gen")
	@SequenceGenerator(name = "account_log_gen", allocationSize = 1, sequenceName = "account_log_gen")
	private int accountLogId;
	
	@CreationTimestamp
	private LocalDateTime accountLogDate;
	
	private int accountLogMoney;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(length = 20)
	private String transactionType;
	
	@Column(length = 50)
	private String transactionReason;
	
	private int transactionAmount;
	
	@JoinColumn(name="user_seq")
	@ManyToOne
	private AccountList accountListByUser;
	
	@JoinColumn(name="account_id")
	@ManyToOne
	private AccountList accountListById;

}
