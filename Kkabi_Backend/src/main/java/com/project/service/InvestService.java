package com.project.service;

import com.project.domain.InvestResult;
import com.project.dto.InvestRequestDTO;

public interface InvestService {

	InvestResult submit(InvestRequestDTO request, int userSeq);

}
