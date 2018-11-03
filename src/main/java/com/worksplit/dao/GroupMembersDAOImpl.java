package com.worksplit.dao;

import java.util.List;

import com.worksplit.dao.interfaces.GroupMembersDAO;
import com.worksplit.tables.GroupMembersTable;
import com.worksplit.tables.GroupConfig;
import com.worksplit.userconfig.User;

public class GroupMembersDAOImpl implements GroupMembersDAO{

	@Override
	public List<GroupMembersTable> addMembers(List<GroupMembersTable> groupMembers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupMembersTable> removeMembers(List<GroupMembersTable> groupMembers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupMembersTable> getMembersOfGroups(List<GroupConfig> groups) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupMembersTable> getGroupsOfMember(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
