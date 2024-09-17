package com.model.Dto;

import java.sql.Date;

import com.model.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data

public class TransactionDto {

	private int transactionId;
	private double transactionAmount;

	private Date transactionDate;

	private TransactionType transactionType;

	private long senderAccountNumber;

	private long receiverAccountNumber;

}
