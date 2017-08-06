package com.wisemoney.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;
import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	//get a user by id
//	@Override
//	public User getUser(int userId) {
//		Session s = HibernateUtil.getSession();
//		Query query = s.createQuery("select u.id, u.firstName, u.lastName, u.username, u.email, u.userRole from User u where u.id=:id");
//		query.setInteger("id", userId);
//		User user = (User) query.uniqueResult();
//		return user;
//	}

	@Override
	public User login(String username, String password) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from User u where u.username=:username and u.password=:password");
		query.setString("username", username);
		query.setString("password", password);
		User user = (User) query.uniqueResult();
//		Criteria cr = s.createCriteria(User.class)
		
		return user;
	}

//	@Override
//	public List<User> getUserList() {
//		Session s = HibernateUtil.getSession();
//		List<User> users = new ArrayList<User>();
//		users = s.createQuery("from User").list();
//		return users;
//	}

	@Override
	public void register(String username, String firstname, String lastname, String password, String email) {
		
		UserRole ur2 = new UserRole("Trader");
		try {
			Session s = HibernateUtil.getSession();             
            // 4. Starting Transaction
            Transaction tx = s.beginTransaction();
            
            Query query = s.createQuery("from UserRole ur where ur.roleName=:roleName");
    			query.setString("roleName", "Trader");
    			UserRole userRole = (UserRole) query.uniqueResult();
            
            User user = new User(firstname, lastname, username, password, email, userRole);
            s.save(user);
            tx.commit();
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
		
	}

}