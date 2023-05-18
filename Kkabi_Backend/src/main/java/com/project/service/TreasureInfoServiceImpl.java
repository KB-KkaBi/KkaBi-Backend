package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.project.domain.AccountInfo;
import com.project.domain.TreasureInfo;
import com.project.repository.TreasureInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TreasureInfoServiceImpl implements TreasureInfoService {

	private final TreasureInfoRepository treasureInfoRep;
	
	@Override
	public List<TreasureInfo> selectAll() {
		return treasureInfoRep.findAll();
	}
}
