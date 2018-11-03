package com.worksplit.dao;

import java.util.List;

import com.worksplit.userconfig.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worksplit.dao.interfaces.DatabasePlugger;
import com.worksplit.dao.interfaces.UsersDAO;
import com.worksplit.userconfig.User;

@Repository
public class UsersDAOImpl implements UsersDAO{
	private final static String TABLE_NAME = "User";

	@Autowired
	UserRepository userRepository;
	@Autowired
	DatabasePlugger databasePlugger;
	@Override
	public User createUserDAO(User user) {
		//databasePlugger.saveValues(user.)
		return userRepository.save(user);
	}

	@Override
	public boolean loginUserDAO(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserPresent(String emailOrPhone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUser(String column, String value) {
		List<User> user = databasePlugger.getValues(TABLE_NAME, column, value);
		return user;
	}


}
