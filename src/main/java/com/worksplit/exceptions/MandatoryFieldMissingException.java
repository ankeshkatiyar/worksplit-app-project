package com.worksplit.exceptions;

import org.springframework.http.HttpStatus;

public class MandatoryFieldMissingException extends RuntimeException {

    private final static Integer status = HttpStatus.BAD_REQUEST.value();

   public MandatoryFieldMissingException(String message){
       super(message);
   }
}
