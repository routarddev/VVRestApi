package vv.codeassignment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private ClientId clientId;
	private Double currentAmount;
	private List<Transaction> transactionList;
	// Other information may be included

	public Account() {
	}

	public Account(ClientId clientId, Double currentAmount, List<Transaction> transactionList) {
		super();
		this.clientId = clientId;
		this.currentAmount = currentAmount;
		this.transactionList = transactionList;
	}

	public ClientId getClientId() {
		return clientId;
	}

	public void setClientId(ClientId clientId) {
		this.clientId = clientId;
	}

	public Double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

}
