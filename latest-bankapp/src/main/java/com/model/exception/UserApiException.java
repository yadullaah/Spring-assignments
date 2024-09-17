package com.model.exception;

import org.springframework.http.HttpStatus;

import com.model.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UserApiException extends RuntimeException {

	private HttpStatus status;
	private String message;
}
