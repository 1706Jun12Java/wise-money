package com.wisemoney.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wisemoney.domain.Stock;
import com.wisemoney.util.HibernateUtil;

public class StockDaoImpl implements StockDao {

	@Override
	public Stock getStockByName(String stockName) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("from Stock ur where ur.stockName=:stockName");
		query.setString("stockName", stockName);
		Stock stock = (Stock) query.uniqueResult();
		
		tx.commit();
		s.close();
		return stock;
	}

	@Override
	public Stock getStockBySymbol(String stockSymbol) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("from Stock ur where ur.stockSymbol=:stockSymbol");
		query.setString("stockSymbol", stockSymbol);
		Stock stock = (Stock) query.uniqueResult();
		
		tx.commit();
		s.close();
		return stock;
	}
	

}
