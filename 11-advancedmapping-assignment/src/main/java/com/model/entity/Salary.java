package com.model.entity;

import com.model.enums.StatusSalary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryId;

    private String salaryMonth;
    private double grossSalary;
    private double deductions;
    private double netSalary;
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private StatusSalary statusSalary;

    @OneToOne(mappedBy = "salary")
    private SalaryTransaction salaryTransaction;
}
