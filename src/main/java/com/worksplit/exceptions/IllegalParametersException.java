package com.worksplit.exceptions;

public class IllegalParametersException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalParametersException(String parameter) {
		super(parameter);
	}

}
