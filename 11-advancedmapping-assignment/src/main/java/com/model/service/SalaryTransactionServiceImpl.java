package com.model.service;

import com.model.dto.SalaryTransactionDto;
import com.model.entity.SalaryTransaction;
import com.model.repository.SalaryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryTransactionServiceImpl implements SalaryTransactionService {

    @Autowired
    private SalaryTransactionRepository transactionRepository;

    @Override
    public SalaryTransactionDto addTransaction(SalaryTransactionDto transactionDto) {
        SalaryTransaction transaction = convertToEntity(transactionDto);
        SalaryTransaction savedTransaction = transactionRepository.save(transaction);
        return convertToDto(savedTransaction);
    }

    @Override
    public SalaryTransactionDto updateTransaction(SalaryTransactionDto transactionDto) {
        SalaryTransaction transaction = convertToEntity(transactionDto);
        SalaryTransaction updatedTransaction = transactionRepository.save(transaction);
        return convertToDto(updatedTransaction);
    }

    @Override
    public Optional<SalaryTransactionDto> getTransactionById(int transactionId) {
        return transactionRepository.findById(transactionId).map(this::convertToDto);
    }

    @Override
    public Page<SalaryTransactionDto> getAllTransactions(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return transactionRepository.findAll(pageable).map(this::convertToDto);
    }

    private SalaryTransaction convertToEntity(SalaryTransactionDto transactionDto) {
        return new SalaryTransaction(
                transactionDto.getTransactionId(),
                transactionDto.getTransactionDate(),
                transactionDto.getAmount(),
                transactionDto.getStatus(),
                transactionDto.getSalaryId(),
        );
    }

    private SalaryTransactionDto convertToDto(SalaryTransaction transaction) {
        return new SalaryTransactionDto(
                transaction.getTransactionId(),
                transaction.getTransactionDate(),
                transaction.getAmount(),
                transaction.getStatus(),
                transaction.getSalaryId()
        );
    }

	@Override
	public Page<SalaryTransactionDto> getAllSalaryTransactions(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryTransactionDto addSalaryTransaction(SalaryTransactionDto salaryTransactionDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryTransactionDto updateSalaryTransaction(SalaryTransactionDto salaryTransactionDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SalaryTransactionDto> getSalaryTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
