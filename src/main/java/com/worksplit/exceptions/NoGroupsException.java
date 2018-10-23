package com.worksplit.exceptions;

public class NoGroupsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoGroupsException() {
		super("No groups to create");
	}

}
