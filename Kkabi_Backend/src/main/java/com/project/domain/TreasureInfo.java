package com.project.domain;

import java.time.LocalDateTime;

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
@Table(name = "treasure_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreasureInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "treasure_id_gen")
	@SequenceGenerator(name = "treasure_id_gen", allocationSize = 1, sequenceName = "treasure_id_gen")
	private int treasureId;
	
	@Column(length = 15)
	private String treasureName;
	
	private double interestRate;
	
	private int price;

}
