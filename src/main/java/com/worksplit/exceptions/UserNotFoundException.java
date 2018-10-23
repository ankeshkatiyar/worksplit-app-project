package com.worksplit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
	public UserNotFoundException(String emailOrPhone) {

		super("User not found for "+ emailOrPhone);
	} 

}
