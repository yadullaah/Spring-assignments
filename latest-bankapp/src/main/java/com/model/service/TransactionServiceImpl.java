package com.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.model.Dto.TransactionDto;
import com.model.entity.Account;
import com.model.entity.Transaction;
import com.model.entity.TransactionType;
import com.model.exception.InsufficientBalanceException;
import com.model.exception.NegativeAmountEnteredException;
import com.model.exception.SameAccountTransferNotAllowedException;
import com.model.exception.ZeroAmountEnteredException;
import com.model.repository.AccountRepository;
import com.model.repository.TransactionRepository;
import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private AccountRepository accountRepo;

	public Transaction toTransactionMapper(TransactionDto transactionDto) {
		Transaction transaction = new Transaction();
		transaction.setSenderAccountNumber(transactionDto.getSenderAccountNumber());
		transaction.setReceiverAccountNumber(transactionDto.getReceiverAccountNumber());
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setTransactionDate(transactionDto.getTransactionDate());
		transaction.setTransactionType(transactionDto.getTransactionType());
		return transaction;
	}

	public TransactionDto toTransactionDtoMapper(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setSenderAccountNumber(transaction.getSenderAccountNumber());
		transactionDto.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
		transactionDto.setTransactionAmount(transaction.getTransactionAmount());
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setTransactionType(transaction.getTransactionType());

		return transactionDto;
	}

	@Override
	public Page<TransactionDto> getAllTransactions(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Transaction> transactionPage = transactionRepo.findAll(pageable);
		return transactionPage.map(this::toTransactionDtoMapper);
	}

	@Override
	public TransactionDto addTransaction(TransactionDto transactionDto) {
		Transaction transaction = toTransactionMapper(transactionDto);

		transaction = transactionRepo.save(transaction);

		return toTransactionDtoMapper(transaction);
	}

	@Override
	public TransactionDto updateTransaction(TransactionDto transactionDto) {
		Transaction transaction = toTransactionMapper(transactionDto);
		transaction.setTransactionId(transactionDto.getTransactionId());

		transaction = transactionRepo.save(transaction);

		return toTransactionDtoMapper(transaction);
	}

	@Override
	public TransactionDto getTransactionById(int transactionId) {
		Transaction transaction = null;
		Optional<Transaction> optionalTransaction = transactionRepo.findById(transactionId);

		if (!optionalTransaction.isPresent()) {
			return null;
		}
		transaction = optionalTransaction.get();
		return toTransactionDtoMapper(transaction);
	}

	public TransactionDto toTransactionDtoWithIdMapper(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTransactionId(transaction.getTransactionId());
		transactionDto.setSenderAccountNumber(transaction.getSenderAccountNumber());
		transactionDto.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
		transactionDto.setTransactionAmount(transaction.getTransactionAmount());
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setTransactionType(transaction.getTransactionType());

		return transactionDto;
	}

	@Override
	@Transactional
	public TransactionDto credit(TransactionDto transactionDto) {

		long accountNumber = transactionDto.getReceiverAccountNumber();
		Account account = accountRepo.findById(accountNumber)
				.orElseThrow(() -> new RuntimeException("Account Not Found"));
		account.setAccountBalance(account.getAccountBalance() + transactionDto.getTransactionAmount());
		accountRepo.save(account);

		Transaction transaction = new Transaction();
		transaction.setSenderAccountNumber(accountNumber);
		transaction.setReceiverAccountNumber(accountNumber);
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setTransactionDate(new Date(System.currentTimeMillis()));
		transaction.setTransactionType(TransactionType.Credit);
		transaction.setAccount(account);
		transactionRepo.save(transaction);

		return toTransactionDtoWithIdMapper(transaction);
	}

	@Override
	@Transactional
	public TransactionDto debit(TransactionDto transactionDto) {

		long accountNumber = transactionDto.getSenderAccountNumber();
		Account account = accountRepo.findById(accountNumber)
				.orElseThrow(() -> new RuntimeException("Account Not Found"));

		if (transactionDto.getTransactionAmount() < 0) {
			throw new NegativeAmountEnteredException();
		}
		
		if (transactionDto.getTransactionAmount() == 0) {
			throw new ZeroAmountEnteredException();
		}

		if (account.getAccountBalance() < transactionDto.getTransactionAmount()) {
			System.out.println("Hello insufficient exception");
			throw new InsufficientBalanceException();
		}

		account.setAccountBalance(account.getAccountBalance() - transactionDto.getTransactionAmount());
		accountRepo.save(account);

		Transaction transaction = new Transaction();
		transaction.setSenderAccountNumber(accountNumber);
		transaction.setReceiverAccountNumber(accountNumber);
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setTransactionDate(new Date(System.currentTimeMillis()));
		transaction.setTransactionType(TransactionType.Debit);
		transaction.setAccount(account);
		transactionRepo.save(transaction);

		return toTransactionDtoWithIdMapper(transaction);
	}

	@Override
	@Transactional
	public TransactionDto transfer(TransactionDto transactionDto) {
		Account senderAccountNumber = accountRepo.findById(transactionDto.getSenderAccountNumber())
				.orElseThrow(() -> new RuntimeException("Sender Account Not Found"));

		Account receiverAccountNumber = accountRepo.findById(transactionDto.getReceiverAccountNumber())
				.orElseThrow(() -> new RuntimeException("Receiver Account Not Found"));

		if (transactionDto.getTransactionAmount() < 0) {
			throw new NegativeAmountEnteredException();
		}

		if (senderAccountNumber.getAccountBalance() < transactionDto.getTransactionAmount())
			throw new InsufficientBalanceException();

		if (senderAccountNumber == receiverAccountNumber) {
			System.out.println("Hello ");
			throw new SameAccountTransferNotAllowedException();
		}

		senderAccountNumber
				.setAccountBalance(senderAccountNumber.getAccountBalance() - transactionDto.getTransactionAmount());

		accountRepo.save(senderAccountNumber);

		receiverAccountNumber
				.setAccountBalance(receiverAccountNumber.getAccountBalance() + transactionDto.getTransactionAmount());
		accountRepo.save(receiverAccountNumber);

		Transaction transaction = new Transaction();
		transaction.setSenderAccountNumber(transactionDto.getSenderAccountNumber());
		transaction.setReceiverAccountNumber(transactionDto.getReceiverAccountNumber());
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setTransactionDate(new Date(System.currentTimeMillis()));
		transaction.setTransactionType(TransactionType.Transfer);
		transaction.setAccount(senderAccountNumber);
		transactionRepo.save(transaction);

		return toTransactionDtoWithIdMapper(transaction);
	}

	@Override
	public List<TransactionDto> getTransactionByAccountNumber(Account account) {

		List<Transaction> transactions = transactionRepo.findByAccount(account);
		List<TransactionDto> transactionDtos = transactions.stream().map(this::toTransactionDtoWithIdMapper)
				.collect(Collectors.toList());

		return transactionDtos;
	}

}
