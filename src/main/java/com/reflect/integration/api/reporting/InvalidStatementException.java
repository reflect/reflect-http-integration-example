package com.reflect.integration.api.reporting;

public class InvalidStatementException extends Exception {
	private static final long serialVersionUID = -7728824151835951116L;

	public InvalidStatementException(String message) {
		super(message);
	}
	
	public InvalidStatementException(String message, Exception e) {
		super(message, e);
	}
}
