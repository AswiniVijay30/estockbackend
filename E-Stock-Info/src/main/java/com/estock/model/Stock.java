package com.estock.model;

import java.util.List;

import com.estock.entity.StockPriceEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	
	private Double maximumStock;
	private Double minimumStock;
	private Double averageStock;
	
	private List<StockPriceEntity> stockDetails; 

	public Double getMaximumStock() {
		return maximumStock;
	}

	public void setMaximumStock(Double maximumStock) {
		this.maximumStock = maximumStock;
	}

	public Double getMinimumStock() {
		return minimumStock;
	}

	public void setMinimumStock(Double minimumStock) {
		this.minimumStock = minimumStock;
	}

	public Double getAverageStock() {
		return averageStock;
	}

	public void setAverageStock(Double averageStock) {
		this.averageStock = averageStock;
	}

    public List<StockPriceEntity> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(List<StockPriceEntity> stockDetails) {
		this.stockDetails = stockDetails;
	} 
	
}
