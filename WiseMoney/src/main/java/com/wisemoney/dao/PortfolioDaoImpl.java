package com.wisemoney.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wisemoney.domain.Portfolio;
import com.wisemoney.util.HibernateUtil;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;
import com.wisemoney.domain.UserRole;

public class PortfolioDaoImpl implements PortfolioDao {

	@Override
	public List<Portfolio> getUserAllStocks(User userId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		List<Portfolio> stocks = new ArrayList<Portfolio>();
		stocks = s.createQuery("from Portfolio p where p.userId=:userId")
							.setParameter("userId", userId).list();
		tx.commit();
		s.close();
		
		return stocks;
	}

	@Override
	public Portfolio getUserStockInfo(User userId, Stock stockId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("from Portfolio p where p.userId=:userId AND p.stockId=:stockId");
		query.setParameter("userId", userId);
		query.setParameter("stockId", stockId);
		Portfolio stockInfo = (Portfolio) query.uniqueResult();
		
		tx.commit();
		s.close();
		return stockInfo;
	}

	@Override
	public void sellUserStockShares(User userId, Stock stockId, int volume) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		if((getUserStockInfo(userId, stockId))!=null) {
			Portfolio userStock = getUserStockInfo(userId, stockId);
			
			if(userStock.getVolume()<volume) {
				System.out.println("User can't sell more shares than user already has");
			}
			else {
				double totalValue = userStock.getTotalValue();
				double valuePerShare = totalValue/(userStock.getVolume());
				
				userStock.setVolume(userStock.getVolume() - volume);
				userStock.setTotalValue(valuePerShare*(userStock.getVolume() - volume));
				userStock.setLastUpdated(new Timestamp(System.currentTimeMillis()));
				userStock.setLastTx("SELL");
				
				s.saveOrUpdate(userStock);
			
			}
			
		}
		else {
			System.out.println("This user does not have any shares of this stock.");
		}
		
		tx.commit();
		s.close();
		
		
	}

	@Override
	public void buyUserStockShares(User userId, Stock stockId, int volume) {
		Session s = HibernateUtil.getSession();
		
		if((getUserStockInfo(userId, stockId))!=null) {
			Portfolio userStock = getUserStockInfo(userId, stockId);
			
			double totalValue = userStock.getTotalValue();
			double valuePerShare = totalValue/(userStock.getVolume());
			
			userStock.setVolume(userStock.getVolume() + volume);
			userStock.setTotalValue(valuePerShare*(userStock.getVolume() + volume));
			userStock.setLastUpdated(new Timestamp(System.currentTimeMillis()));
			userStock.setLastTx("BUY");
			
			s.saveOrUpdate(userStock);
		}
		else {
			
		}
		
	}

}
