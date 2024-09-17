package com.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import com.model.enums.KycStatus;
import com.model.enums.Status;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "registration_number")
	private int registrationNumber;

	@Column(name = "contact_person")
	private String contactPerson;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "contact_number")
	private int contactNumber;

	@Column(name = "address")
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "kyc_status")
	private KycStatus kycStatus;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees;

}
