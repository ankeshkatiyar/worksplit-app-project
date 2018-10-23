package com.worksplit.service.interfaces;

import com.worksplit.models.UserModel;
import com.worksplit.tables.User;

public interface UserService {
	
	public UserModel createUser(User user);
	public UserModel loginUser(User user);

}
