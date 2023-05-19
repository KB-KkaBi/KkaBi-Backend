package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.domain.QuizLog;

@Repository
public interface QuizLogRepository  extends JpaRepository<QuizLog, Integer>{
	@Query(value="select q from QuizLog q where q.quizInfo.quizId=:quizId")
	List <QuizLog> findAllQuizLog(int quizId);
}
