package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;import com.sun.xml.bind.v2.runtime.Name;

@Repository(value="stockRepository")
public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByCodeAndDateBetween(String st_Code, Date startDate, Date endDate);
	
	List<Stock> findByCodeAndCloseGreaterThan(String st_Code, BigDecimal close);
	
	List<Stock> findTop3ByOrderByVolumeDesc();
	
	List<Stock> findTop3ByCodeOrderByVolumeAsc(String st_Code);
}
