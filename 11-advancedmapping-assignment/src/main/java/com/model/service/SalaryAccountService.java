package com.model.service;

import com.model.dto.SalaryAccountDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SalaryAccountService {

    Page<SalaryAccountDto> getAllSalaryAccounts(int pageNumber, int pageSize);

    SalaryAccountDto addSalaryAccount(SalaryAccountDto salaryAccountDto);

    SalaryAccountDto updateSalaryAccount(SalaryAccountDto salaryAccountDto);

    Optional<SalaryAccountDto> getSalaryAccount(long accountNumber);
}
