package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entity.BankAccount;
import com.model.repository.BankAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        BankAccount fromAccount = bankAccountRepository.findById(fromAccountId)
            .orElseThrow(() -> new RuntimeException("Source account not found"));
        BankAccount toAccount = bankAccountRepository.findById(toAccountId)
            .orElseThrow(() -> new RuntimeException("Destination account not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds in source account");
        }

        // Deduct amount from source account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        bankAccountRepository.save(fromAccount);

        // Add amount to destination account
        toAccount.setBalance(toAccount.getBalance() + amount);
        bankAccountRepository.save(toAccount);
    }
}
