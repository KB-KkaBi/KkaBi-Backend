package com.project.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.TreasureLog;
import com.project.dto.Treasure;

@Repository
public interface TreasureLogRepository extends JpaRepository<TreasureLog, Integer> {

	@Query(value="select coalesce(sum(t.cnt * t.treasureInfo.price),0) from TreasureLog t "
			+ "group by t.user.userSeq "
			+ "having t.user.userSeq = :userSeq")
	int selectSumOfMyTreausreJPQL(@Param("userSeq") int userSeq);
	
	@Query(value="select t.treasureInfo.treasureId treasure, sum(t.cnt) cnt from TreasureLog t "
			+ "where t.user.userSeq = :userSeq "
			+ "group by t.treasureInfo.treasureId")
	List<Treasure> selectDetailTreasureJPQL(@Param("userSeq") int userSeq);
}
