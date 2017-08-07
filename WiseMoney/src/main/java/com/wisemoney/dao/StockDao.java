package com.wisemoney.dao;

import java.util.List;

import com.wisemoney.domain.Stock;

public interface StockDao {
	
	public Stock getStockByName(String stockName);
	public Stock getStockBySymbol(String stockSymbol);
	public List<Stock> getStockList();

}
