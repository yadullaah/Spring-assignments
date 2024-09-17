package com.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

    private String bankName;
    private String branch;
    private String ifsc;

    @OneToMany(mappedBy = "bank")
    private List<SalaryAccount> salaryAccounts;
}
