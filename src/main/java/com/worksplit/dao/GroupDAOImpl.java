package com.worksplit.dao;

import java.util.List;

import com.worksplit.tables.GroupConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worksplit.dao.interfaces.DatabasePlugger;
import com.worksplit.dao.interfaces.GroupDAO;

@Repository
public class GroupDAOImpl  implements GroupDAO{
	
	public static final Logger LOG = LoggerFactory.getLogger(GroupDAOImpl.class);
	@Autowired
	DatabasePlugger databasePlugger;

	@Override
	@SuppressWarnings(value = { "unchecked" })
	public List<GroupConfig> createOrUpdateGroups(List<GroupConfig> groupsMaster) {
		List<GroupConfig> list = (List<GroupConfig>)databasePlugger.saveOrUpdateMultipleValues(groupsMaster);
		return list;

	}

	@Override
	public List<GroupConfig> deleteGroups(List<GroupConfig> groupsMaster) {
		List<GroupConfig> list = (List<GroupConfig>)databasePlugger.saveOrUpdateMultipleValues(groupsMaster);
		return list;
	}



}
