package com.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CustomerDto {
	private int customerId;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String username;
	private String password;

}
