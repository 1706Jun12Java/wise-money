package com.wisemoney.dao;

import com.wisemoney.domain.Login;
import com.wisemoney.domain.User;

public interface UserService {
	
	void register(User user);
	User validateUser(Login login);
}
