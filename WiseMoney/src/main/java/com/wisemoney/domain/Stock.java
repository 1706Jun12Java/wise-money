package com.wisemoney.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WM_STOCK")
public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5988828071225278979L;

	@Id
	@Column(name="STOCK_ID", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="StockIdSequence")
	@SequenceGenerator(allocationSize=1, name="StockIdSequence", sequenceName="STOCK_ID_SEQ")
	private int stockId;
	
	@Column(name="STOCK_NAME", unique=true)
	private String stockName;
	
	@Column(name="STOCK_SYMBOL", unique=true)
	private String stockSymbol;
	

	public Stock(String stockName, String stockSymbol) {
		super();
		//this.stockId = stockId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
	}
	

	public Stock(String stockName, String stockSymbol, List<Portfolio> portfolio) {
		super();
		//this.stockId = stockId;
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}	

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}


	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockSymbol=" + stockSymbol
				+ "]";
	}
}
