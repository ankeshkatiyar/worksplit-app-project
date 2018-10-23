package com.worksplit.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worksplit.service.interfaces.TaskService;
import com.worksplit.tables.Tasks;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@RequestMapping(value = "createtask")
	public @ResponseBody ResponseEntity<List<Tasks>> createTask(@RequestBody List<Tasks> tasks) {	
		
			return new ResponseEntity<>(taskService.createTask(tasks) ,  HttpStatus.CREATED );

	}
	
	@RequestMapping(value = "getalltasks" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Tasks>> getAllTasks() {	
		
			return new ResponseEntity<>(taskService.getAllTasks() ,  HttpStatus.OK );

	}
	
	
	@RequestMapping(value = "gettasks" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Tasks>> getTasks(@RequestParam(name = "parameter")String column 
															,  @RequestParam("value")  String value) {	
		
			return new ResponseEntity<>(taskService.getTask(column, value) ,  HttpStatus.OK );

	}
	
}
