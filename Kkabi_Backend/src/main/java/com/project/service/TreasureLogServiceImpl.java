package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.DetailTreasureDTO;
import com.project.dto.Treasure;
import com.project.repository.TreasureLogRepository;

@Service
public class TreasureLogServiceImpl implements TreasureLogService {
	
	@Autowired
	TreasureLogRepository treasureLogRep;

	@Override
	public DetailTreasureDTO findDetailTreasure(int userSeq) {
		
		DetailTreasureDTO detailTreasure = new DetailTreasureDTO();
		
		List<Treasure> t = treasureLogRep.selectDetailTreasureJPQL(userSeq);
		
		for(Treasure item : t) {
			switch (item.getTreasure()) {
			case 1:
				detailTreasure.setTreasure1(item.getCnt());
				break;
			case 2:
				detailTreasure.setTreasure2(item.getCnt());
				break;
			case 3:
				detailTreasure.setTreasure3(item.getCnt());
				break;
			case 4:
				detailTreasure.setTreasure4(item.getCnt());
				break;
			default:
				break;
			}
		}
		
		return detailTreasure;
	}

}
