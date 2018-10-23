package com.worksplit.exceptions;

import java.util.Date;

import com.worksplit.models.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    ErrorResponse error;
	
	public GlobalExceptionHandler() {
	
	}

	
	@ExceptionHandler(value = {PasswordIncorrectException.class})
	public  ResponseEntity<ErrorResponse> handlePasswordIncorrectException (PasswordIncorrectException e) {
		String message[]  = e.getMessage().split(",");
		error.setErrorCode(1005);
		error.setError("Password Incorrect");
		error.setTimestamp(new Date().getTime());
		error.setUserId(message[0]);
		error.setDevice(message[1]);
		return  new ResponseEntity<>(error , HttpStatus.ACCEPTED);
		
		
	}
	
	@ExceptionHandler(value = {NoTasksException.class})
	public  ResponseEntity<ErrorResponse> handleNoTasksException () {
		error.setErrorCode(1006);
		error.setError("No tasks to create");
		error.setTimestamp(new Date().getTime());
		return  new ResponseEntity<>(error , HttpStatus.ACCEPTED);
		
		
	}
	
	@ExceptionHandler(value = {IllegalParametersException.class})
	public  ResponseEntity<ErrorResponse> handleIllegalParametersException () {
		error.setErrorCode(1007);
		error.setError("Illegal parameters passed");
		error.setTimestamp(new Date().getTime());
		return  new ResponseEntity<>(error , HttpStatus.ACCEPTED);
		
		
	}
	
	@ExceptionHandler(value = {NoGroupsException.class})
	public  ResponseEntity<ErrorResponse> handleNoGroupsException() {
		error.setErrorCode(1008);
		error.setError("No groups to create");
		error.setTimestamp(new Date().getTime());
		return  new ResponseEntity<>(error , HttpStatus.ACCEPTED);
		
		
	}
	

	
}
