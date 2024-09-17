package com.model.exception;

public class StudentDoesNotExistsException extends RuntimeException {
	
	public String getMessage() {
		return "Student Does Not Exists";
	}

}