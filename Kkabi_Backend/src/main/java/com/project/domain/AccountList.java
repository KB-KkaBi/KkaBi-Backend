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
@Table(name = "account_list")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_list_gen")
	@SequenceGenerator(name = "account_list_gen", allocationSize = 1, sequenceName = "account_list_gen")
	private int accountId;
	
	@Column(length = 20)
	private String accountName;
	
	private int accountMoney;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(length = 1)
	private String status;
	
	@JoinColumn(name="user_seq")
	@ManyToOne
	private User user;
	
	@JoinColumn(name="account_info_id")
	@ManyToOne
	private AccountInfo accountInfo;
	
	/**
	 * AccountLog insert를 위한 생성자
	 * 
	 * @param accountId
	 * @param user
	 */
	public AccountList(int accountId, User user) {
		this.accountId = accountId;
		this.user = user;
	}

}
