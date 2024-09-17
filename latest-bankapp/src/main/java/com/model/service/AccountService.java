package com.model.service;

import org.springframework.data.domain.Page;
import com.model.Dto.AccountDto;

public interface AccountService {
	Page<AccountDto> getAllAccounts(int pageNumber, int pageSize);

	AccountDto addAccount(AccountDto accountDto);

	AccountDto updateAccount(AccountDto accountDto);

	AccountDto getAcountById(long accountNumber);
}
