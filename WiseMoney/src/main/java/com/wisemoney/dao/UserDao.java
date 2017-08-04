package com.wisemoney.dao;

import java.util.List;

import com.wisemoney.domain.User;

public interface UserDao {
	
	public User getUser(int userId); //get details of a specific user
	public int login(String username, String password);
//	public void logout();
	public List<User> getUserList(); //manager can view all employees
	public void register(String username, String firstname, String lastname, String password, String email);

}
