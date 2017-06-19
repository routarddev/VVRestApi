package vv.codeassignment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private Long accountId;
	private Double amount;
	private Double previousAmount;
	private Double transactionAmount;
	private String typeOfTransaction;
	private LocalDateTime date;


	public Transaction(Long accountId, Double amount, Double previousAmount, Double transactionAmount,
			String typeOfTransaction, LocalDateTime date) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.previousAmount = previousAmount;
		this.transactionAmount = transactionAmount;
		this.typeOfTransaction = typeOfTransaction;
		this.date = date;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getPreviousAmount() {
		return previousAmount;
	}

	public void setPreviousAmount(Double previousAmount) {
		this.previousAmount = previousAmount;
	}

}
