package com.worksplit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worksplit.dao.interfaces.DatabasePlugger;
import com.worksplit.dao.interfaces.RelationshipDAO;
import com.worksplit.models.UserModel;
import com.worksplit.tables.Relationship;

@Repository
public class RelationshipDAOImpl implements RelationshipDAO {

	@Autowired
	DatabasePlugger databasePlugger;
	private final static String TABLE_NAME = "User";

	@Override
	public List<UserModel> getUser(String column, String value) {
		List<UserModel> user = databasePlugger.getValues(TABLE_NAME, column, value);
		return user;
	}

	@Override
	public Boolean inviteFriendsDao(Relationship relationship) {
		
		return (Boolean)databasePlugger.saveValues(relationship) ;

		//return databasePlugger.saveValues(relationship);

	}



	@Override
	public boolean blockFriendDao(Relationship relationship) {

		return (Boolean) databasePlugger.saveValues(relationship);
	}

	@Override
	public boolean acceptRequestDao(Relationship relationship) {

		return (Boolean) databasePlugger.saveValues(relationship);
	}

	@Override
	public boolean declineRequestDao(Relationship relationship) {

		return (Boolean) databasePlugger.saveValues(relationship);
	}

	@Override
	public boolean unblockUserDao(Relationship relationship) {

		return (Boolean) databasePlugger.saveValues(relationship);
	}

	@Override
	public boolean removeUserDao(Relationship relationship) {

		return (Boolean) databasePlugger.saveValues(relationship);
	}

	@Override
	public List<UserModel> getFriendList(Integer userId) {
		
		return databasePlugger.getFriendList(userId);
	}

}
