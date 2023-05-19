package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.TreasureInfo;

public interface TreasureInfoRepository extends JpaRepository<TreasureInfo, Integer> {
	public TreasureInfo findByTreasureId(int id);
}
