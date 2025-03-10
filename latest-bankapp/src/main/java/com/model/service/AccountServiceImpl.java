package com.model.service;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.model.Dto.AccountDto;
import com.model.entity.Account;
import com.model.entity.Customer;
import com.model.repository.AccountRepository;
import com.model.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private CustomerRepository customerRepo;

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	public Account toAccountMapper(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountBalance(accountDto.getAccountBalance());
		return account;
	}

	public AccountDto toAccountDtoMapper(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountBalance(account.getAccountBalance());
		accountDto.setCustomerId(account.getCustomer().getCustomerId());
		return accountDto;
	}

	@Override
	public Page<AccountDto> getAllAccounts(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Account> accountPage = accountRepo.findAll(pageable);
		return accountPage.map(this::toAccountDtoMapper);
	}

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		long accountNumber = generateUniqueAccountNumber();
		System.out.println("acc" + accountNumber);
		accountDto.setAccountNumber(accountNumber);

		Customer customer = customerRepo.findById(accountDto.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer Not Found"));

		Account account = toAccountMapper(accountDto);
		account.setCustomer(customer);
		account.setAccountNumber(accountNumber);
		account = accountRepo.save(account);
		account.setCustomer(customer);
		System.out.println(customer.getCustomerId());
		return toAccountDtoMapper(account);
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto) {
		Account account = toAccountMapper(accountDto);
		account.setAccountNumber(accountDto.getAccountNumber());

		account = accountRepo.save(account);

		return toAccountDtoMapper(account);
	}

	@Override
	public AccountDto getAcountById(long accountNumber) {
		Account account = null;
		Optional<Account> optionalAccount = accountRepo.findById(accountNumber);

		if (!optionalAccount.isPresent()) {
			return null;
		}
		account = optionalAccount.get();
		return toAccountDtoMapper(account);
	}

	private long generateUniqueAccountNumber() {
		Random random = new Random();
		long accountNumber;
		do {
			accountNumber = 100000000L + random.nextLong(900000000); // Generates a 9-digit number
		} while (accountRepo.existsByAccountNumber(accountNumber));
		return accountNumber;
	}

}