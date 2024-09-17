package com.model.repository;

import java.util.List;
import com.model.entity.Loan;

public interface LoanRepository {

	List<Loan> getAllLoans();

	Loan getLoan(int loanId);

	void addLoan(Loan loan);
}
