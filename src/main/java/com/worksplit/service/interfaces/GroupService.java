package com.worksplit.service.interfaces;

import java.util.List;

import com.worksplit.tables.GroupConfig;

public interface GroupService {

	public List<GroupConfig> createOrUpdateGroups(List<GroupConfig> groupsMaster);
	public List<GroupConfig> deleteGroups(List<GroupConfig> groupsMaster);

}
