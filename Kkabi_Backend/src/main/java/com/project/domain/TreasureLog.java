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
@Table(name = "treasure_log")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreasureLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "treasure_log_gen")
	@SequenceGenerator(name = "treasure_log_gen", allocationSize = 1, sequenceName = "treasure_log_gen")
	private int treasureLogId;

	@CreationTimestamp
	private LocalDateTime treasureLogDate;

	private int cnt;

	@JoinColumn(name = "user_seq")
	@ManyToOne
	private User user;

	@JoinColumn(name = "treasure_id")
	@ManyToOne
	private TreasureInfo treasureInfo;

	public TreasureLog(int cnt, User user, TreasureInfo treasureInfo) {
		this.cnt = cnt;
		this.user = user;
		this.treasureInfo = treasureInfo;
	}

}
