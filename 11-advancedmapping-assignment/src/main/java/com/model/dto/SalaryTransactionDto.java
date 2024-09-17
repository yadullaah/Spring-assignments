package com.model.dto;

import com.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryTransactionDto {

    private int transactionId;
    private LocalDate transactionDate;
    private double amount;
    private Status status;
    private int salaryId;
}
