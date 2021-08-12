package com.estock.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.entity.StockPriceEntity;
import com.estock.model.Stock;
import com.estock.repository.StockPriceRepository;
import com.estock.service.StockService;

@Service
public class StockServiceImpl implements StockService {

  
  @Autowired
  StockPriceRepository stockPriceRepository;  
  
  
  public String addStockPrice(String companyCode,float stockPrice) {
	  StockPriceEntity getStockPrice = new StockPriceEntity();
	  getStockPrice.setCode(companyCode);
	  getStockPrice.setCreatedDate(LocalDateTime.now());
	  getStockPrice.setStockprice(stockPrice);
	  stockPriceRepository.save(getStockPrice);
	  return "Stock price Added Successfully";
  }
  
  public Stock fetchStockPrice(String companyCode, LocalDate startdate, LocalDate enddate) {
	  List<StockPriceEntity> getAllStock = stockPriceRepository.getAllBetweenDates(companyCode,startdate,enddate);
	  DoubleSummaryStatistics stats = getAllStock.stream()
              						.mapToDouble(x -> x.getStockprice())
              						.summaryStatistics();
	  
	  Stock getStock = new Stock();
	  getStock.setAverageStock(stats.getAverage());
	  getStock.setMaximumStock(stats.getMax());
	  getStock.setMinimumStock(stats.getMin());
	  getStock.setStockDetails(getAllStock);	 
	  return getStock;
  } 
  
  public String deleteCompany(String companyCode) {	  
	  List<StockPriceEntity> getAllStock = stockPriceRepository.findAllByCode(companyCode); 
	  String result;
	  stockPriceRepository.deleteAll(getAllStock);
	  result = "Successfully Deleted Stocks for  "+companyCode;	 
	  return result;
  } 
  
  public List<StockPriceEntity> fetchStock(String companyCode) {
	   return stockPriceRepository.findAllByCode(companyCode);
	  
  }
}