package com.model.service;

import com.model.dto.SalaryAccountDto;
import com.model.entity.SalaryAccount;
import com.model.repository.SalaryAccountRepository;
import com.model.service.SalaryAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryAccountServiceImpl implements SalaryAccountService {

    @Autowired
    private SalaryAccountRepository salaryAccountRepository;

    private SalaryAccountDto convertToDto(SalaryAccount salaryAccount) {
        return new SalaryAccountDto(
                salaryAccount.getAccountNumber(),
                salaryAccount.getAccountHolderName(),
                salaryAccount.getBank().getBankId()
        );
    }

    private SalaryAccount convertToEntity(SalaryAccountDto salaryAccountDto) {
        SalaryAccount salaryAccount = new SalaryAccount();
        salaryAccount.setAccountNumber(salaryAccountDto.getAccountNumber());
        salaryAccount.setAccountHolderName(salaryAccountDto.getAccountHolderName());
        // Fetch Bank entity using bankId and set it to salaryAccount
        return salaryAccount;
    }

    @Override
    public Page<SalaryAccountDto> getAllSalaryAccounts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return salaryAccountRepository.findAll(pageable).map(this::convertToDto);
    }

    @Override
    public SalaryAccountDto addSalaryAccount(SalaryAccountDto salaryAccountDto) {
        SalaryAccount salaryAccount = convertToEntity(salaryAccountDto);
        return convertToDto(salaryAccountRepository.save(salaryAccount));
    }

    @Override
    public SalaryAccountDto updateSalaryAccount(SalaryAccountDto salaryAccountDto) {
        SalaryAccount salaryAccount = convertToEntity(salaryAccountDto);
        return convertToDto(salaryAccountRepository.save(salaryAccount));
    }

    @Override
    public Optional<SalaryAccountDto> getSalaryAccount(long accountNumber) {
        return salaryAccountRepository.findById(accountNumber).map(this::convertToDto);
    }
}
