package com.wisemoney.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.wisemoney.domain.Login;
import com.wisemoney.domain.User;
import com.wisemoney.domain.UserRole;
import com.wisemoney.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void register(User user) {
		String sql = "insert into users values(?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstName(),
	    user.getLastName(), user.getEmail() });
	}

	@Override
	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	}
	
	class UserMapper implements RowMapper<User> {
		  public User mapRow(ResultSet rs, int arg1) throws SQLException {
		    User user = new User();
		    user.setUsername(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		    user.setFirstName(rs.getString("firstname"));
		    user.setLastName(rs.getString("lastname"));
		    user.setEmail(rs.getString("email"));
		    return user;
		  }
		}
	
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
