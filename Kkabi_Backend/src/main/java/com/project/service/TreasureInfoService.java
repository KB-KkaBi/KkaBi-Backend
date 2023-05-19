package com.project.service;

import java.util.List;

import com.project.domain.AccountInfo;
import com.project.domain.TreasureInfo;

public interface TreasureInfoService {
	/**
	 * 전체검색
	 */
	List<TreasureInfo> selectAll();

}
