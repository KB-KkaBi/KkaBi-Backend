package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.domain.TreasureInfo;

@Repository
public interface TreasureInfoRepository extends JpaRepository<TreasureInfo, Integer> {
	public TreasureInfo findByTreasureId(int id);
}
