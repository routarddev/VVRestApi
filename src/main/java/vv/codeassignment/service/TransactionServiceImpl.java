package vv.codeassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vv.codeassignment.model.Transaction;
import vv.codeassignment.repository.TransactionRepository;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getAllTransactionsByAccountId(Long accountId) {
		return (List<Transaction>) transactionRepository.getTransactionByAccountId(accountId);
	}

	@Override
	public void createTransaction(Transaction transaction) {
		transactionRepository.saveAndFlush(transaction);
	} 

}
