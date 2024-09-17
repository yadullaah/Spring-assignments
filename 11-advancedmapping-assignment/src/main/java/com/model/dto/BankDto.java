package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    private int bankId;
    private String bankName;
    private String branch;
    private String ifsc;
    private List<SalaryAccountDto> salaryAccounts;
}
