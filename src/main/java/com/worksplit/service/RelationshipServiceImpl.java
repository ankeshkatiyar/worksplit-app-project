 package com.worksplit.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worksplit.dao.RelationshipDAOImpl;
import com.worksplit.models.RelationshipModel;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.RelationshipService;
import com.worksplit.tables.Relationship;
import com.worksplit.utils.StatusCodes;

@Service
public class RelationshipServiceImpl implements RelationshipService {

	public RelationshipServiceImpl() {
		System.out.println("Scanning  RelationshipIMpl");
	}

	@Autowired
	RelationshipDAOImpl relationshipActivitiesDao;

	@Autowired
	Relationship relationshipTable;

	@Override
	public RelationshipModel inviteFriend(RelationshipModel relationship) {
		// RelationshipModel will be filled and returned from this method whereas
		// Relationship Table will be sent forward
		List<UserModel> user = null;
		if (relationship != null) {
			relationshipTable.setUserOneId(relationship.getUserOneId());
			if (relationship.getEmailOrPhone().contains("@")) {
				user = relationshipActivitiesDao.getUser("email", relationship.getEmailOrPhone());
			} else {
				user = relationshipActivitiesDao.getUser("mob", relationship.getEmailOrPhone());
			}
			if (user != null && !user.isEmpty()) {
				//relationship.setUserTwoId(user.get(0).getUserId());
				//relationshipTable.setUserTwoId(user.get(0).getUserId());
				relationshipTable.setStatus(PENDING);
				relationshipTable.setActionUserId(relationship.getUserOneId());
				if (!relationshipActivitiesDao.inviteFriendsDao(relationshipTable)) {
					relationship.setError(StatusCodes.DATABASE_ERROR_OCCURED);
				}
			} else {
				relationship.setError(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		return relationship;

	}

	@Override
	public List<UserModel> getFriends(String emailOrPhone) {

		List<UserModel> user = null;
		List<UserModel> friends = null;

		if (emailOrPhone.contains("@")) {
			user = relationshipActivitiesDao.getUser("email", emailOrPhone);
		} else {
			user = relationshipActivitiesDao.getUser("mob", emailOrPhone);
		}

		//friends = relationshipActivitiesDao.getFriendList(user.get(0).getUserId());
		return friends;
	}

	@Override
	public RelationshipModel blockFriend(RelationshipModel relationship) {
		if (relationship != null) {
			relationship.setStatus(BLOCKED);
			relationship.setActionUserId(relationship.getUserTwoId());
			if (!relationshipActivitiesDao.inviteFriendsDao(relationshipTable)) {
				relationship.setError(StatusCodes.DATABASE_ERROR_OCCURED);
			} else {
				relationship.setError(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		return relationship;

	}

	@Override
	public RelationshipModel acceptRequest(RelationshipModel relationship) {
		if (relationship != null) {
			relationship.setStatus(ACCEPTED);
			relationship.setActionUserId(relationship.getUserTwoId());
			if (!relationshipActivitiesDao.inviteFriendsDao(relationshipTable)) {
				relationship.setError(StatusCodes.DATABASE_ERROR_OCCURED);
			}

			else {
				relationship.setError(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		return relationship;
	}

	@Override
	public RelationshipModel removeFriend(RelationshipModel relationship) {
		if (relationship != null) {
			relationship.setStatus(REMOVED);
			relationship.setActionUserId(relationship.getUserTwoId());

			if (!relationshipActivitiesDao.inviteFriendsDao(relationshipTable)) {
				relationship.setError(StatusCodes.DATABASE_ERROR_OCCURED);
			}

			else {
				relationship.setError(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		return relationship;
	}

	@Override
	public RelationshipModel unblockFriend(RelationshipModel relationship) {
		if (relationship != null) {
			relationship.setStatus(ACCEPTED);
			relationship.setActionUserId(relationship.getUserOneId());

			if (!relationshipActivitiesDao.inviteFriendsDao(relationshipTable)) {
				relationship.setError(StatusCodes.DATABASE_ERROR_OCCURED);
			}

			else {
				relationship.setError(StatusCodes.USER_DOES_NOT_EXIST);
			}
		}
		return relationship;
	}

}
