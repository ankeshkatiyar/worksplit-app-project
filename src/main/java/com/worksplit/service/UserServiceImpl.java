package com.worksplit.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worksplit.dao.interfaces.UsersDAO;
import com.worksplit.exceptions.PasswordIncorrectException;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.UserService;
import com.worksplit.tables.User;
import com.worksplit.utils.StatusCodes;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersDAO usersDAO;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private UserModel userModel;
	
	private List<User> userEmailCheck;
	private List<User> userMobCheck;
	
	@Override
	public UserModel createUser(User user) {
		
		userEmailCheck = usersDAO.getUser("email", user.getEmail());
		userMobCheck = usersDAO.getUser("mob", user.getMob());

		if (userEmailCheck != null && !userEmailCheck.isEmpty()) {

			userModel.setStatuscodes(StatusCodes.EMAIL_ALREADY_REGISTERED);

		} else {
			if (userMobCheck != null && !userMobCheck.isEmpty()) {
				
				userModel.setStatuscodes(StatusCodes.MOBILE_NUMBER_ALREADY_REGISTERED);

			} else {
				
				user = usersDAO.createUserDAO(user);
				if (user.getUserId() == null) {
					
					userModel.setStatuscodes(StatusCodes.DATABASE_ERROR_OCCURED);
				}

			}
		}
		userModel =  copyTableToModel(userModel, user);
		return userModel;

	}

	@Override
	public UserModel loginUser(User user){
		
		if(user.getEmail() != null ) {
			userEmailCheck = usersDAO.getUser("email", user.getEmail());
			if(userEmailCheck!=null && !userEmailCheck.isEmpty()){
				if(user.getPassword().equals(userEmailCheck.get(0).getPassword())){
					
					userModel = copyTableToModel(userModel, userEmailCheck.get(0));
				}else {
					userModel.setStatuscodes(StatusCodes.PASSWORD_INCORRECT);
					String tempUserId = Integer.toString( userEmailCheck.get(0).getUserId());
					String tempDevice = userEmailCheck.get(0).getDevice();
					throw new PasswordIncorrectException(tempUserId +","+ tempDevice);
									 
				}
				
			}else {
				userModel.setStatuscodes(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		
		if(user.getMob() != null ) {
			userMobCheck = usersDAO.getUser("mob", user.getEmail());
			if(userMobCheck!=null && !userMobCheck.isEmpty()){
				if(user.getPassword().equals(userMobCheck.get(0).getPassword())){
					
					userModel = copyTableToModel(userModel, userEmailCheck.get(0));
				}else {
					userModel.setStatuscodes(StatusCodes.PASSWORD_INCORRECT);
				}
				
			}else {
				userModel.setStatuscodes(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		
	
		return userModel;
	}
	
	public UserModel copyTableToModel(UserModel model , User user) {
		
		model.setName( user.getName());
		model.setEmail(user.getEmail());
		model.setMob(user.getMob());
		model.setPassword(user.getPassword());
		model.setDevice(user.getDevice());
		model.setCreatedon(user.getCreatedon());
		model.setLastlogin(user.getLastlogin());
		model.setUserId(user.getUserId());
		return model;
	}
	


}
