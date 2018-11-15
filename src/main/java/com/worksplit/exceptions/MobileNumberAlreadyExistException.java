package com.worksplit.exceptions;

public class MobileNumberAlreadyExistException extends  RuntimeException {
    public MobileNumberAlreadyExistException(String mob) {
        super(mob + " already exist ");
    }
}
