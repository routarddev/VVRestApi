package vv.codeassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vv.codeassignment.model.Transaction;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	public Transaction getTransactionByAccountId(Long accountId);
	
}
