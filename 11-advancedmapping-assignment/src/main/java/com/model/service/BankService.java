package com.model.service;

import com.model.dto.BankDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BankService {

    Page<BankDto> getAllBanks(int pageNumber, int pageSize);

    BankDto addBank(BankDto bankDto);

    BankDto updateBank(BankDto bankDto);

    Optional<BankDto> getBank(int bankId);
}
