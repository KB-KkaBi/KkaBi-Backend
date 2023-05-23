package com.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "quiz_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "quiz_id_gen")
	@SequenceGenerator(name = "quiz_id_gen", allocationSize = 1, sequenceName = "quiz_id_gen")
	private int quizId;

	@Column(length = 100)
	private String problem;

	@Column(length = 20)
	private String answer;

	@Column(length = 100)
	private String array;
	
	private String hint;

	@JoinColumn(name = "treasure_id")
	@ManyToOne
	private TreasureInfo treasureInfo;

}
