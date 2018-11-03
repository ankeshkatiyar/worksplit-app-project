package com.worksplit.dao.interfaces;

import java.util.List;

import com.worksplit.tables.GroupMembersTable;
import com.worksplit.tables.GroupConfig;
import com.worksplit.userconfig.User;

public interface GroupMembersDAO {
	
	public List<GroupMembersTable> addMembers( List<GroupMembersTable>  groupMembers);
	public List<GroupMembersTable> removeMembers( List<GroupMembersTable>  groupMembers);
	public List<GroupMembersTable> getMembersOfGroups(List<GroupConfig> groups);
	public List<GroupMembersTable> getGroupsOfMember(List<User> users);

}
