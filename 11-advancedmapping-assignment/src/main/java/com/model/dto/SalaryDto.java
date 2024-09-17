package com.model.dto;

import com.model.enums.StatusSalary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {

    private int salaryId;
    private String salaryMonth;
    private double grossSalary;
    private double deductions;
    private double netSalary;
    private LocalDate paymentDate;
    private StatusSalary statusSalary;
}
