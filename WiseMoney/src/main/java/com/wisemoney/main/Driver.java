package com.wisemoney.main;

import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.wisemoney.domain.Portfolio;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;
import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		testingDomain();

	}
	
	static void testingDomain() {
		Date date = new Date();
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		UserRole ur1 = new UserRole("Admin");
//		UserRole ur2 = new UserRole("Trader");
		
//		User u1 = new User("Maksim", "Loginoff", "usermaksim", "maksimpass", "maksim@gmail.com", ur2);
//		//User u2 = new User("Kate", "Loginoff", "userkate", "katepass", "kateloginoff@gmail.com", ur2);
//		//User u3 = new User("Mister", "Spinner", "usermister", "misterpass", "misterspinner@gmail.com", ur2);
//				
//		Stock s1 = new Stock("Microsoft", "MSFT");
//		Stock s2 = new Stock("Alphabet", "GOOG");
//		Stock s3 = new Stock("Apple", "AAPL");
//		
		//Portfolio p1 = new Portfolio(u1,date,date,1,5,365.00,"BUY");
		//Portfolio p2 = new Portfolio(u1,date,date,2,5,4705.00,"BUY");
		//Portfolio p3 = new Portfolio(u1,date,date,3,5,745.00,"SELL");
		//Portfolio p4 = new Portfolio(u2,date,date,1,3,219.00,"BUY");
		//Portfolio p5 = new Portfolio(u2,date,date,2,3,2823.00,"BUY");
		//Portfolio p6 = new Portfolio(u2,date,date,3,3,447.00,"BUY");
		//Portfolio p7 = new Portfolio(u3,date,date,1,7,511.00,"SELL");
		//Portfolio p8 = new Portfolio(u3,date,date,2,7,6587.00,"BUY");
		//Portfolio p9 = new Portfolio(u3,date,date,3,7,1043.00,"SELL");		
 
		s.save(ur1);
//		s.save(ur2);
		
//		s.save(u1);
		//s.save(u2);
		//s.save(u3);
		
//		s.save(s1);
//		s.save(s2);
//		s.save(s3);
		
		//s.save(p1);
		//s.save(p2);
		//s.save(p3);
		//s.save(p4);
		//s.save(p5);
		//s.save(p6);
		
//		p1.getStock().add(s1);
//				
		tx.commit();
		s.close();
	}

}
