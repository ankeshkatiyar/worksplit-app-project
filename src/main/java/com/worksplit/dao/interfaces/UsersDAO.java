package com.worksplit.dao.interfaces;

import com.worksplit.userconfig.User;

import java.util.List;

public interface UsersDAO {
	
	public User createUserDAO(User user);
	public boolean loginUserDAO(User user);
	public List<User> getUser(String column , String value);
	public boolean isUserPresent(String emailOrPhone);

}
