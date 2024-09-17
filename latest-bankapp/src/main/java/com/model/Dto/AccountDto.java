package com.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AccountDto {

	private long accountNumber;
	private double accountBalance;
	private int customerId;

}
