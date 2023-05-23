package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.domain.TreasureLog;

@Repository
public interface TreasureLogRepository extends JpaRepository<TreasureLog, Integer> {

}
