package com.model.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoanId")
	private int LoanId;

	@Column(name = "LoanAmount")
	private double LoanAmount;

	@Column(name = "interestRate")
	private double interestRate;

	@Column(name = "LoanTerm")
	private int LoanTerm; // in months

	@Column(name = "startDate")
	private LocalDate startDate;

	@Column(name = "endDate")
	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "loanStatus")
	private LoanStatus loanStatus;

	public enum LoanStatus {
		APPLIED, PENDING, REJECTED, APPROVED
	}


	public int getLoanId() {
		return LoanId;
	}

	public void setLoanId(int loanId) {
		this.LoanId = loanId;
	}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.LoanAmount = loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getLoanTerm() {
		return LoanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.LoanTerm = loanTerm;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	
	public Loan() {
	}

	public Loan(double loanAmount, double interestRate, int loanTerm, LocalDate startDate, LocalDate endDate,
			LoanStatus loanStatus) {
		this.LoanAmount = loanAmount;
		this.interestRate = interestRate;
		this.LoanTerm = loanTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanStatus = loanStatus;
	}
}
