package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.domain.QuizInfo;

public interface QuizInfoRepository extends JpaRepository<QuizInfo, Integer> {

	@Query(value = "select a from QuizInfo a where a.treasureInfo.treasureId = :treasure_Id")
	public List<QuizInfo> findAllByTreasureIdJPQL(@Param("treasure_Id") int treasureId);

}
