package com.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_info_id_gen")
	@SequenceGenerator(name = "account_info_id_gen", allocationSize = 1, sequenceName = "account_info_id_gen")
	private int accountInfoId;
	
	@Column(length = 30)
	private String accountType;
	private double interestRate;
	
	@Column(length = 300)
	private String information;
	
	public AccountInfo(int accountInfoId) {
		this.accountInfoId = accountInfoId;
	}
	
}
