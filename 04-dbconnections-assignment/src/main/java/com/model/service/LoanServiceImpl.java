package com.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.entity.Loan;
import com.model.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepo;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepo.getAllLoans();
    }

    @Override
    public Loan getLoan(int loanId) {
        return loanRepo.getLoan(loanId);
    }

    @Override
    public void addLoan(Loan loan) {
        loanRepo.addLoan(loan);
    }
}
