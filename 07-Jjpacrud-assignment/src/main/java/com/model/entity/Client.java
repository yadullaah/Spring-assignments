
package com.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "registrationNumber")
	private int registrationNumber;

	@Column(name = "contactPerson")
	private String contactPerson;

	@Column(name = "contactEmail")
	private String contactEmail;

	@Column(name = "contactNumber")
	private int contactNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "status")
	private Status status;

	@Column(name = "creationDate")
	private LocalDate creationDate;

	@Column(name = "kycStatus")
	private KycStatus kycStatus;

	public enum Status {
		ACTIVE, INACTIVE
	}

	public enum KycStatus {
		PENDING, DONE, REJECTED
	}
}
