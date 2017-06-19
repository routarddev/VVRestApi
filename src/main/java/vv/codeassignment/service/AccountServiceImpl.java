package vv.codeassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vv.codeassignment.model.Account;
import vv.codeassignment.model.Transaction;
import vv.codeassignment.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Transaction> getAllTransactionsByAccountId(Long accountId) {
		return accountRepository.getOne(accountId).getTransactionList();
	}

	@Override
	public List<Account> getAccountsByUserId(Long userId) {
		return accountRepository.getAccountsByUserId(userId);
	}

	@Override
	public Account getAccountByAccountId(Long accountId) {
		return accountRepository.getOne(accountId);
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.saveAndFlush(account);
	}

	@Override
	public void createAccount(Long userId, Account account) {
		accountRepository.saveAndFlush(account);
	}
	

}
