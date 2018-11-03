package com.worksplit.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String user) {
        super(user + " already exist in the system");
    }
}
