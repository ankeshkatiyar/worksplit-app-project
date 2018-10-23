package com.worksplit.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import com.worksplit.models.UserModel;

@Service
public interface DatabasePlugger {
	
	public Object saveValues(Object object);
	public boolean isPresent(String tableName ,String column , String value);
	public <T> List<T>  getValues(String tableName ,String column , String value);
	public List<UserModel> getFriendList(Integer userId);
	public <T> List<T>  getAllValues(String tableName); 
	public Object saveOrUpdateMultipleValues(List<?> objects);


}
