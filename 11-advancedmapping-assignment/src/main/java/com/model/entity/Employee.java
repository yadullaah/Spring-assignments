package com.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import com.model.enums.Status;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private long phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "position")
	private String position;

	@Column(name = "hire_date")
	private LocalDate hireDate;

	@Column(name = "salary")
	private double salary;

	@Column(name = "account_number")
	private long accountNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

}
