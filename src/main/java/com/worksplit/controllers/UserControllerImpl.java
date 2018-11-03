package com.worksplit.controllers;

import com.worksplit.controllers.interfaces.UserController;
import com.worksplit.dto.UserDTO;
import com.worksplit.userconfig.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper objectMapper;

    @Override
    public @ResponseBody ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
        try {
            return new ResponseEntity<UserDTO>(userService.createUser(user), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            List<String> list = new ArrayList<>();
            list.add(e.getMessage());
            return new ResponseEntity<UserDTO>( new UserDTO(true ,list) ,  HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
	public @ResponseBody ResponseEntity<UserModel> loginUser(@RequestBody User user) {
			return new ResponseEntity<UserModel>(userService.loginUser(user), HttpStatus.OK);
	}

		

}
