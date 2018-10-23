package com.worksplit.controllers;

import com.worksplit.controllers.interfaces.GroupController;
import com.worksplit.tables.GroupConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.worksplit.exceptions.NoGroupsException;
import com.worksplit.service.interfaces.GroupService;
import java.io.IOException;
import java.util.List;

@RestController
public class GroupControllerImpl implements GroupController {
	
	@Autowired
	private GroupService groupService;

	@Override
	public @ResponseBody ResponseEntity<List<GroupConfig>> createGroups(@RequestBody List<GroupConfig> groups) throws IOException {
		if(groups != null  && !groups.isEmpty()) {
			return new ResponseEntity<>(groupService.createOrUpdateGroups(groups) , HttpStatus.OK);
		}
		else {
			throw new NoGroupsException();
		}
	}

	@Override
	public @ResponseBody ResponseEntity<List<GroupConfig>> deleteGroups(@RequestBody List<GroupConfig> groups) {
		if(groups != null  && !groups.isEmpty()) {
			return new ResponseEntity<>(groupService.deleteGroups(groups) , HttpStatus.OK);
		}
		else {
			throw new NoGroupsException();
		}
	}


}
