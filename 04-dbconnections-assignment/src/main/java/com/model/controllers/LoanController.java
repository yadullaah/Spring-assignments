package com.model.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.entity.Loan;
import com.model.service.LoanService;

@RestController
@RequestMapping("/app")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
    
    @GetMapping("/loans/{loanId}")
    public ResponseEntity<Loan> getLoan(@PathVariable int loanId) {
        return ResponseEntity.ok(loanService.getLoan(loanId));
    }
    
    @PostMapping("/loans")
    public String addLoan(@RequestBody Loan loan) {
        loanService.addLoan(loan);
        return "Loan added successfully";
    }
}
