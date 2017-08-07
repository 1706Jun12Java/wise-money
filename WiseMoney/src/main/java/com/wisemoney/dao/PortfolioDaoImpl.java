package com.wisemoney.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.wisemoney.domain.Portfolio;
import com.wisemoney.util.HibernateUtil;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;

@Service
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
			
			//if user attempts to sell more shares than he actually has
			if(userStock.getVolume()<volume) {
				System.out.println("User can't sell more shares than user already has");
			}
			//if user attempts to sell less shares than he has
			else if(userStock.getVolume()>volume){
				double totalValue = userStock.getTotalValue();
				double valuePerShare = totalValue/(userStock.getVolume());
				
				userStock.setTotalValue(valuePerShare*(userStock.getVolume() - volume));
				userStock.setVolume(userStock.getVolume() - volume);
				userStock.setLastUpdated(new Timestamp(System.currentTimeMillis()));
				userStock.setLastTx("SELL");
				
				s.saveOrUpdate(userStock);
				
				tx.commit();
				s.close();
			
			} //if user is selling all of his remaining shares, just remove the part of the user's portfolio of that stock
			else if(userStock.getVolume()==volume) {
				Query query = s.createQuery("delete Portfolio p where p.userId=:userId AND p.stockId=:stockId");
				query.setParameter("userId", userId);
				query.setParameter("stockId", stockId);
				query.executeUpdate();
				
				tx.commit();
				s.close();
			}
			
		}
		else { //user has no shares to sell
			System.out.println("This user does not have any shares of this stock.");
		}		
		
	}

	@Override
	public void buyUserStockShares(User userId, Stock stockId, int volume) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		//if user already owns a share(s) of this stock
		if((getUserStockInfo(userId, stockId))!=null) {
			Portfolio userStock = getUserStockInfo(userId, stockId);
			
			double totalValue = userStock.getTotalValue();
			double valuePerShare = totalValue/(userStock.getVolume());
			
			userStock.setTotalValue(valuePerShare*(userStock.getVolume() + volume));
			userStock.setVolume(userStock.getVolume() + volume);
			userStock.setLastUpdated(new Timestamp(System.currentTimeMillis()));
			userStock.setLastTx("BUY");
			
			s.saveOrUpdate(userStock);
			
			tx.commit();
			s.close();
		}
		//if user doesn't already own a share(s) of this stock
		else {
			 double stockPricePerShare = stockId.getStockValue();
			 double totalValue = volume * stockPricePerShare;
			 
			 Date now = new Date();
			 Timestamp currentTimestamp = new Timestamp(now.getTime());
			 
				                    			
    			Portfolio portfolio = new Portfolio(userId, currentTimestamp, currentTimestamp, stockId, volume, totalValue, "BUY");
    			s.save(portfolio);
    			tx.commit();
		}
		
	}

}
