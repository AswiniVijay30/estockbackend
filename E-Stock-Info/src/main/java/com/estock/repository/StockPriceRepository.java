package com.estock.repository;

import java.time.LocalDate;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;


import com.estock.entity.StockPriceEntity;

public interface StockPriceRepository extends CrudRepository<StockPriceEntity,Long> {

	@Query(value = "Select * from stockprice where code=?1",nativeQuery = true)
	List<StockPriceEntity> findAllByCode(String companyCode);
	
	@Query(value = "SELECT * FROM stockprice WHERE CODE= ?1 AND cast(CREATEDDATE as date) >= ?2 AND cast(CREATEDDATE as date) <= ?3", nativeQuery = true)
	List<StockPriceEntity> getAllBetweenDates(String code,LocalDate startDate, LocalDate endDate);

}
