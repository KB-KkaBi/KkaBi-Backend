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
@Table(name = "quiz_log")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "quiz_log_id_gen")
	@SequenceGenerator(name = "quiz_log_id_gen", allocationSize = 1, sequenceName = "quiz_log_id_gen")
	private int quizLogId;

	@CreationTimestamp
	private LocalDateTime quizLogDate;

	@Column(length = 1)
	private String success;

	@JoinColumn(name = "user_seq")
	@ManyToOne
	private User user;

	@JoinColumn(name = "quiz_id")
	@ManyToOne
	private QuizInfo quizInfo;

	public QuizLog(String success, User user, QuizInfo quizInfo) {
		this.success = success;
		this.user = user;
		this.quizInfo = quizInfo;
	}
}
