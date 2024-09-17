package com.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class InsufficientBalanceException extends RuntimeException {
	public String getMessage() {
		return "You Have Insufficient Balance.";
	}

}
