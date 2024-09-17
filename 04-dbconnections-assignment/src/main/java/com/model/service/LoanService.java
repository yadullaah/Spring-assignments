package com.model.service;

import java.util.List;
import com.model.entity.Loan;

public interface LoanService {
    
    List<Loan> getAllLoans();
    
    Loan getLoan(int loanId);
    
    void addLoan(Loan loan);
}
