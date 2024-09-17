package com.model.dto;

import com.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private String position;
    private LocalDate hireDate;
    private double salary;
    private long accountNumber;
    private Status status;
    private int clientId;
}
