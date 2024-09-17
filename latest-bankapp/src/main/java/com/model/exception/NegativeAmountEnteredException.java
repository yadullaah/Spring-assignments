package com.model.exception;

public class NegativeAmountEnteredException extends RuntimeException{
	public String getMessage() {
		return "You have entered amount in Negative";
	}
}
