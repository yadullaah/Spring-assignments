package com.model.exception;

public class ZeroAmountEnteredException extends RuntimeException {
	public String getMessage() {
		return "You have entered zero";
	}

}
