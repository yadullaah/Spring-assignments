package com.model.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BankErrorResponse {

	private int status;
	private String errorMessage;
	private long timeStamp;

}
