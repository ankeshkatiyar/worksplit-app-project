package com.worksplit.service.interfaces;

import com.worksplit.dto.UserDTO;
import com.worksplit.models.UserModel;
import com.worksplit.userconfig.User;

public interface UserService {
	
	 UserDTO createUser(User user);
	 UserModel loginUser(User user);

}
