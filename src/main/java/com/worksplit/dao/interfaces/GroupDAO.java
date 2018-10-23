package com.worksplit.dao.interfaces;

import java.util.List;

import com.worksplit.tables.GroupConfig;

public interface GroupDAO {
	
	public List<GroupConfig> createOrUpdateGroups(List<GroupConfig> groupsMaster);
	public List<GroupConfig>  deleteGroups(List<GroupConfig> groupsMaster);

}
