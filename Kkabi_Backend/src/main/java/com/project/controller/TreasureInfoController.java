package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.TreasureInfo;
import com.project.service.TreasureInfoService;

@RestController
public class TreasureInfoController {
	@Autowired
	private TreasureInfoService treasureInfoService;

	@GetMapping("/treasure-info")
	public List<TreasureInfo> getTreasureList() {
		List<TreasureInfo> list = treasureInfoService.selectAll();
		return list;
	}

}
