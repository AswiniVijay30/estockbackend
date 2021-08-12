package com.estock.serviceimpl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
import com.estock.entity.StockPriceEntity;
import com.estock.model.Stock;
import com.estock.repository.StockPriceRepository;

@RunWith(SpringRunner.class)
public class StockServiceImplTest {
	
	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@InjectMocks
	StockServiceImpl stockServiceImpl;
	
	@Mock
	StockPriceRepository stockPriceRepository;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new StockServiceImpl()).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddStockPrice() {
		StockPriceEntity stock = new StockPriceEntity();
		stock.setCode("001");
		stock.setStockprice(454.5f);
		stock.setCreatedDate(LocalDateTime.now());
		stock.setId(1);
		stockPriceRepository.save(stock);
		stockServiceImpl.addStockPrice("001", 454.5f);
		assertEquals("Stock price Added Successfully", stockServiceImpl.addStockPrice("001", 454.5f));
	}
	
	@Test
	public void testFetchStockPrice() {
		
		when(stockPriceRepository.getAllBetweenDates(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(getStockPriceDetails());
		Stock stock = stockServiceImpl.fetchStockPrice("001", LocalDate.now(), LocalDate.now());
		assertNotNull(stock);
	}
	
	@Test
	public void testDeleteCompany() {
	
		when(stockPriceRepository.findAllByCode(Mockito.anyString())).thenReturn(getStockPriceDetails());
		stockPriceRepository.deleteAll();
		stockServiceImpl.deleteCompany("001");
		assertEquals("Successfully Deleted Stocks for  001",stockServiceImpl.deleteCompany("001"));
	}
	
	@Test
	public void testFetchStock() {
		
		when(stockPriceRepository.findAllByCode(Mockito.anyString())).thenReturn(getStockPriceDetails());
		List<StockPriceEntity> stockList = stockServiceImpl.fetchStock("001");
		assertNotNull(stockList);
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
