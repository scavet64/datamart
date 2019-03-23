package com.team12.datamart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team12.datamart.domain.DateDimension;
import com.team12.datamart.repo.DateDimensionRepo;

@Service
public class DateDimensionService {

	@Autowired
	private DateDimensionRepo dateRepo;

	public void saveDateDimensions(List<DateDimension> dates) {
		dateRepo.saveAll(dates);
	}

	public Long getCount() {
		return dateRepo.count();
	}

}
