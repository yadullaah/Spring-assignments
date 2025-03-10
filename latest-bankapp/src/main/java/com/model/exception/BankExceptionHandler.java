package com.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.model.errors.BankErrorResponse;

@ControllerAdvice
public class BankExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleInsufficientBalanceException(
			InsufficientBalanceException exception) {
		System.out.println("handler called");
		BankErrorResponse error = new BankErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleNegativeAmountEnteredException(
			NegativeAmountEnteredException exception) {

		BankErrorResponse error = new BankErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleZeroAmountEnteredException(ZeroAmountEnteredException exception) {

		BankErrorResponse error = new BankErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler
	public ResponseEntity<BankErrorResponse> handleSameAccountTransferNotAllowedException(
			SameAccountTransferNotAllowedException exception) {

		BankErrorResponse error = new BankErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
