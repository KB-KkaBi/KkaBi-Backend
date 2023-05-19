package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.TreasureLog;

public interface TreasureLogRepository extends JpaRepository<TreasureLog, Integer> {

}
