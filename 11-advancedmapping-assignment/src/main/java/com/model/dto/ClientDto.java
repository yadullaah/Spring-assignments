package com.model.dto;

import com.model.enums.KycStatus;
import com.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private int clientId;
    private String companyName;
    private int registrationNumber;
    private String contactPerson;
    private String contactEmail;
    private int contactNumber;
    private String address;
    private Status status;
    private LocalDate creationDate;
    private KycStatus kycStatus;
    private List<EmployeeDto> employees; // List of Employee DTOs
}
