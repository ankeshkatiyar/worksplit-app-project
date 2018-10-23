package com.worksplit.utils;

public enum StatusCodes {
	

	USER_ALREADY_EXIST(1001 , "User already exist"),
	USER_DOES_NOT_EXIST(1002 , "User does not exist"),
	EMAIL_ALREADY_REGISTERED(1003 , "Email Id already registered"),
	MOBILE_NUMBER_ALREADY_REGISTERED(1004 , "Mobile Number already registered"),
	PASSWORD_INCORRECT(1005,"Password is incorrect"),
	DATABASE_ERROR_OCCURED(5001,"ErrorResponse occured while accessing db");
	
	
	

	
	private final int errorCode;
	private final String errorMessage;
	
	
	 StatusCodes(int errorcode , String message) {
		 this.errorCode = errorcode;
		 this.errorMessage = message;
		
	}


	public int getErrorCode() {
		return errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}
	

}
