package com.estock.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estock.entity.StockPriceEntity;
import com.estock.model.Stock;
import com.estock.service.StockService;


@RestController
@RequestMapping(path = "/api/v1.0/market")
public class StockInfoController {


  @Autowired
  private StockService stockService; 
 
  
  @GetMapping(value = "/stock/delete/{companyCode}")
  public String deleteStock(@PathVariable(name = "companyCode", required = true) String companyCode) {
	   return stockService.deleteCompany(companyCode);
	  
  } 
  
  @PostMapping(value = "/stock/add/{companyCode}")
  public String addStock(@PathVariable(name = "companyCode", required = true) String companyCode,
		  			@RequestParam(name = "stockPrice", required = true) float stockPrice) {
	  return stockService.addStockPrice(companyCode,stockPrice);
	  
	  
  }
  
  @GetMapping(value = "/stock/get/{companyCode}/{startdate}/{enddate}")
  public Map<String,Object> fetchStockPriceList(@PathVariable(name = "companyCode", required = true) String companyCode,
		  @PathVariable(name = "startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate startdate,
		  @PathVariable(name = "enddate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enddate){
	  Stock getStock =  stockService.fetchStockPrice(companyCode,startdate,enddate);
	  HashMap <String, Object> getData = new HashMap <> ();
	  if(!getStock.getStockDetails().isEmpty()) {
		  getData.put("data", getStock);
	  }else {
		  getData.put("error", "No Records Found");
	  }	  
	  return getData;
  } 
  
  @GetMapping(value = "/stock/getStock/{companyCode}")
  public List<StockPriceEntity> fetchStockPrice(@PathVariable(name = "companyCode", required = true) String companyCode){
	  return  stockService.fetchStock(companyCode);	  
  } 
}