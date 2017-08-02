package com.wisemoney.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisemoney.domain.Login;
import com.wisemoney.domain.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;
	
	@Override
	public void register(User user) {
		userDao.register(user);
	}

	@Override
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
}
