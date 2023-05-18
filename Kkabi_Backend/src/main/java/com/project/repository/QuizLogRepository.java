package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.QuizLog;

public interface QuizLogRepository  extends JpaRepository<QuizLog, Integer>{

}
