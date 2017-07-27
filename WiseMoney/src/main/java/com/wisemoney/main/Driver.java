package com.wisemoney.main;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;

import com.wisemoney.domain.Portfolio;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		testingDomain();

	}
	
	static void testingDomain() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
//		UserRole ur1 = new UserRole(1, "Trader");
//		Portfolio p1 = new Portfolio();

//		Stock s1 = new Stock(1, "GOOGLE", "GG");
//		p1.setTotalValue(65);
//		p1.getStock().add(s1);
//		s.save(ur1);
//		s.save(s1);
		
		tx.commit();
		s.close();
	}

}
