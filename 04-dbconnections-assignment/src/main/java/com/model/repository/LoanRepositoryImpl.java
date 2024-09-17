package com.model.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.entity.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class LoanRepositoryImpl implements LoanRepository {

    @Autowired
    private EntityManager manager;

    @Override
    public List<Loan> getAllLoans() {
        TypedQuery<Loan> query = manager.createQuery("select l from Loan l", Loan.class);
        return query.getResultList();
    }

    @Override
    public Loan getLoan(int loanId) {
        return manager.find(Loan.class, loanId);
    }

    @Override
    @Transactional
    public void addLoan(Loan loan) {
        manager.persist(loan);
    }
}
