package com.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentErrorResponse {

	private int status;
	private String errorMessage;
	private long timestamp;

}