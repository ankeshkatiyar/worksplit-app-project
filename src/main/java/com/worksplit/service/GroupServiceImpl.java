package com.worksplit.service;

import java.util.ArrayList;
import java.util.List;

import com.worksplit.controllers.UserControllerImpl;
import com.worksplit.tables.GroupConfig;
import com.worksplit.utils.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worksplit.dao.interfaces.GroupDAO;
import com.worksplit.service.interfaces.GroupService;


@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupDAO groupDAO;

	@Autowired
    UserControllerImpl controller;


	public static final Logger LOG = LoggerFactory.getLogger(GroupServiceImpl.class);
	@Override
	public List<GroupConfig> createOrUpdateGroups(List<GroupConfig> groupsMaster) {
		List<GroupConfig> listGroups = new ArrayList<>();
		StringBuilder groupNames =  new StringBuilder();
		if(groupsMaster != null  && !groupsMaster.isEmpty()) {
			if(RequestValidator.performGroupConfigValuesValidation(groupsMaster)) {

				listGroups = groupDAO.createOrUpdateGroups(groupsMaster);
				LOG.info("GroupConfig created or udpated" + groupNames);
			}
		}
		return listGroups;

	}
	@Override
	public List<GroupConfig> deleteGroups(List<GroupConfig> groupsMasterList) {
		List <GroupConfig> groupsDeleted = new ArrayList<>();
		if(groupsMasterList != null  && !groupsMasterList.isEmpty()) {
			for(GroupConfig groupsMaster : groupsMasterList) {
				groupsMaster.setIsDeleted(true);
			}
			groupsDeleted = groupDAO.deleteGroups(groupsMasterList);
		}
		return groupsDeleted;
	}



	
}
