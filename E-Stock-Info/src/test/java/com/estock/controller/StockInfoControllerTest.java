package com.estock.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.estock.entity.StockPriceEntity;
import com.estock.repository.StockPriceRepository;
import com.estock.service.StockService;

@RunWith(SpringRunner.class)
public class StockInfoControllerTest {

	@SuppressWarnings("unused")
	private MockMvc mockMvc;
	
	@InjectMocks 
	StockInfoController stockInfoController;
	
	@Mock
	StockService stockService;
	
	@Mock
	StockPriceRepository stockPriceRepository;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new StockInfoController()).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testDeleteStock() {
		
		when(stockService.deleteCompany(Mockito.anyString())).thenReturn("success");
		stockPriceRepository.findAllByCode("123");
		stockInfoController.deleteStock("123");
		assertEquals("success", stockInfoController.deleteStock("123"));
	}
	
	@Test
	public void testAddStock() {
		
		when(stockService.addStockPrice(Mockito.anyString(), Mockito.anyFloat())).thenReturn("Stock price Added Successfully");
		stockInfoController.addStock("002", 531.2f);
		assertEquals("Stock price Added Successfully", stockInfoController.addStock("002", 531.2f));
	}
	
	@Ignore
	@Test
	public void testFetchStockPriceList() {
		
		when(stockService.fetchStock(Mockito.anyString())).thenReturn(getStockPriceDetails());
		stockInfoController.fetchStockPriceList("002",LocalDate.now() , LocalDate.now());
	}
	
	@Test
	public void testFetchStockPrice() {
		
		when(stockService.fetchStock(Mockito.anyString())).thenReturn(getStockPriceDetails());
		stockInfoController.fetchStockPrice("002");
		assertNotNull(stockInfoController.fetchStockPrice("002"));
	}

	private List<StockPriceEntity> getStockPriceDetails() {
		List<StockPriceEntity> stockList = new ArrayList<StockPriceEntity>();
		StockPriceEntity stockPrice = new StockPriceEntity();
		stockPrice.setCode("002");
		stockPrice.setCreatedDate(LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40));
		stockPrice.setStockprice(777.7f);
		stockPrice.setId(1);
		return stockList;
	}

}
