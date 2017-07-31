package com.wisemoney.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wisemoney.domain.User;
import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	//get a user by id
	@Override
	public User getUser(int userId) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("from User u where u.id=:id");
		query.setInteger("id", userId);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public int login(String username, String password) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("select userId from User u where u.username=:username and u.password=:password");
		query.setString("username", username);
		query.setString("password", password);
		int userId = (int) query.uniqueResult();
		return userId;
	}

	@Override
	public List<User> getUserList() {
		Session s = HibernateUtil.getSession();
		List<User> users = new ArrayList<User>();
		users = s.createQuery("from User").list();
		return users;
	}

	@Override
	public void addNewUser(String username, String firstname, String lastname, String password, String email) {
		UserRole ur2 = new UserRole("Trader");
		try {
			Session s = HibernateUtil.getSession();             
            // 4. Starting Transaction
            Transaction tx = s.beginTransaction();
            User user = new User(username,firstname,lastname,password,email,ur2);
            //user.setFirstName(firstname);
            s.save(user);
            tx.commit();
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
		
	}

}
