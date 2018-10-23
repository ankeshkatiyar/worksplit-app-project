package com.worksplit.exceptions;

public class NoTasksException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoTasksException() {
		super("No tasks to create");
	}

}
