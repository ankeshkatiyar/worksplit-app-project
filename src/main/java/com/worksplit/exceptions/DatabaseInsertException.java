package com.worksplit.exceptions;


public class DatabaseInsertException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseInsertException() {
		super("Problem in Saving the values");
	}

}
