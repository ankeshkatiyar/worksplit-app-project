package com.worksplit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.UserService;
import com.worksplit.tables.User;

@RestController
public class UserControllerImpl {

	@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(value = "registration", method = RequestMethod.POST, produces = "application/json")

	public @ResponseBody ResponseEntity<UserModel> createUser(@RequestBody User user) {
		try {

			return new ResponseEntity<UserModel>(userService.createUser(user), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "loginuser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseEntity<UserModel> loginUser(@RequestBody User user) {


			return new ResponseEntity<UserModel>(userService.loginUser(user), HttpStatus.OK);
	}

		

}
