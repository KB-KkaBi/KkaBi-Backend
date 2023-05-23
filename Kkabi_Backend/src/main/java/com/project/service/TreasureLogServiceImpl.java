package com.project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dto.DetailTreasureDTO;
import com.project.repository.TreasureLogRepository;

public class TreasureLogServiceImpl implements TreasureLogService {
	
	@Autowired
	TreasureLogRepository treasureLogRep;

	@Override
	public DetailTreasureDTO selectDetailTreasure(int userSeq) {
		
		DetailTreasureDTO detailTreasure = new DetailTreasureDTO();
		
		Map<Integer, Integer> map = treasureLogRep.selectDetailTreasureJPQL(userSeq);
				
		return null;
	}

}
