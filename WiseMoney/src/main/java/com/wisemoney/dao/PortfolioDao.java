package com.wisemoney.dao;

import java.util.List;

import com.wisemoney.domain.Portfolio;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;

public interface PortfolioDao {
	
	public List<Portfolio> getUserAllStocks(User userId);
	public Portfolio getUserStockInfo(User userId, Stock stockId);
	public void sellUserStockShares(User userId, Stock stockId, int volume);
	public void buyUserStockShares(User userId, Stock stockId, int volume);
	
	

}
