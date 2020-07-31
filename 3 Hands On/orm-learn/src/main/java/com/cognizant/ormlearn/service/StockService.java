package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Transactional
	public List<Stock> findAll() {
		return stockRepository.findAll();
	}
	
	@Transactional
	public List<Stock> stocksByCodeAndMonth(String st_Code, Date startDate, Date endDate) {
		return stockRepository.findByCodeAndDateBetween(st_Code, startDate, endDate);
	}
	
	@Transactional
	public List<Stock> stocksByCodeAndCloseGreaterThan(String st_Code, BigDecimal close) {
		return stockRepository.findByCodeAndCloseGreaterThan(st_Code, close);
	}
	
	@Transactional
	public List<Stock> top3StockByVolume() {
		return stockRepository.findTop3ByOrderByVolumeDesc();
	}
	
	@Transactional
	public List<Stock> bottom3StockByCodeAndVolume(String st_Code) {
		return stockRepository.findTop3ByCodeOrderByVolumeAsc(st_Code);
	}
}
