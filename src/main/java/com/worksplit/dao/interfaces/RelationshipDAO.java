package com.worksplit.dao.interfaces;

import java.util.List;
import com.worksplit.models.UserModel;
import com.worksplit.tables.Relationship;
public interface RelationshipDAO{
	
	Boolean inviteFriendsDao(Relationship relationship);
	List<UserModel> getFriendList(Integer userId);
	boolean blockFriendDao(Relationship relationship);
	boolean acceptRequestDao(Relationship relationship);
	boolean declineRequestDao(Relationship relationship);
	boolean unblockUserDao(Relationship relationship);
	boolean removeUserDao(Relationship relationship);
	List<UserModel> getUser(String column, String value);

}
