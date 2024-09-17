package com.model.service;

import com.model.dto.SalaryTransactionDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SalaryTransactionService {

    Page<SalaryTransactionDto> getAllSalaryTransactions(int pageNumber, int pageSize);

    SalaryTransactionDto addSalaryTransaction(SalaryTransactionDto salaryTransactionDto);

    SalaryTransactionDto updateSalaryTransaction(SalaryTransactionDto salaryTransactionDto);

    Optional<SalaryTransactionDto> getSalaryTransaction(int transactionId);
}
