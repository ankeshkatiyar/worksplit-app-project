package com.worksplit.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.worksplit.models.RelationshipModel;
import com.worksplit.models.UserModel;

@Service
public interface RelationshipService {

	public static final int PENDING = 0;
	public static final int ACCEPTED = 1;
	public static final int DECLINED = 2;
	public static final int BLOCKED = 3;
	public static final int REMOVED = 4;
	RelationshipModel inviteFriend(RelationshipModel relationship);
	List<UserModel> getFriends(String emailOrPhone);
	RelationshipModel  blockFriend(RelationshipModel relationship);
	RelationshipModel  acceptRequest(RelationshipModel relationship);
	RelationshipModel  unblockFriend(RelationshipModel relationship);
	RelationshipModel  removeFriend(RelationshipModel relationship);
	
}
