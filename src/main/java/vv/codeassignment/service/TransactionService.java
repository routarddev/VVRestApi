package vv.codeassignment.service;

import java.util.List;

import vv.codeassignment.model.Transaction;

public interface TransactionService {
	
	public List<Transaction> getAllTransactionsByAccountId(Long accountId);
	public void createTransaction(Transaction transaction);
	
}
