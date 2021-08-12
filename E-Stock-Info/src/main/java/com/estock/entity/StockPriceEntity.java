package com.estock.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockprice", catalog = "estock")
public class StockPriceEntity implements Serializable {
	
	
	private static final long serialVersionUID = 4518290119722159053L;	
		
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public float getStockprice() {
		return stockprice;
	}

	public void setStockprice(float stockprice) {
		this.stockprice = stockprice;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="CODE")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="STOCKPRICE",precision=8, scale=2)
    private float stockprice;
	
	@Column(name="CREATEDDATE")
	private LocalDateTime createdDate;	

}
