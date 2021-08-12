package com.estock.service;
  
import java.time.LocalDate;
import java.util.List;


import com.estock.entity.StockPriceEntity;
import com.estock.model.Stock;
  
  
  public interface StockService {	
	String addStockPrice(String companyCode,float stockPrice);
	Stock fetchStockPrice(String companyCode, LocalDate startdate, LocalDate enddate);
	String deleteCompany(String companyCode);
	List<StockPriceEntity> fetchStock(String companyCode);
  
  }
 