package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.TreasureLog;

@Repository
public interface TreasureLogRepository extends JpaRepository<TreasureLog, Integer> {

	@Query(value="select coalesce(sum(t.cnt * t.treasureInfo.price),0) from TreasureLog t "
			+ "group by t.user.userSeq "
			+ "having t.user.userSeq = :userSeq")
	int selectSumOfMyTreausreJPQL(@Param("userSeq") int userSeq);
	
}
