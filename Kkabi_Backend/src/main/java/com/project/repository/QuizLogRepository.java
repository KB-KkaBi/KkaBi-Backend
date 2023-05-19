package com.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.QuizLog;

@Repository
public interface QuizLogRepository  extends JpaRepository<QuizLog, Integer>{
	int nowPage = 1;
	int PAGE_COUNT = 5;
	Pageable page = PageRequest.of((nowPage-1), PAGE_COUNT);
	
	@Query(value="select q from QuizLog q where q.user.userSeq=:userSeq order by q.quizLogId desc")
	Page<QuizLog> findAllQuizLog(@Param("userSeq") int userSeq, Pageable page);
}
