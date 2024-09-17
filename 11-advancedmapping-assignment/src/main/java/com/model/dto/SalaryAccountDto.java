package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryAccountDto {

    private long accountNumber;
    private String accountHolderName;
    private int bankId;
}
