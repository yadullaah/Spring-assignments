package com.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDto {
	private String username;
	private String password;
	private String role;
//	private String firstName;
//	private String lastName;
//	private long mobileNumber;

}
