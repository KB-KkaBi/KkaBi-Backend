package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.QuizInfo;

public interface QuizInfoRepository extends JpaRepository<QuizInfo, Integer> {

	public List<QuizInfo> findByLev(int level);

}
