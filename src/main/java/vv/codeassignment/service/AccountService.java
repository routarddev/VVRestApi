package vv.codeassignment.service;

import java.util.List;

import vv.codeassignment.model.Account;
import vv.codeassignment.model.Transaction;

public interface AccountService {
	
	public Account getAccountByAccountId(Long accountId);
	public List<Account> getAccountsByUserId(Long userId);
	public List<Transaction> getAllTransactionsByAccountId(Long accountId);
	public void updateAccount(Account account);
	public void createAccount(Long userId, Account account);
}
