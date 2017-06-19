package vv.codeassignment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private ClientId clientId;
	private String name;
	private String surname;
	private String phoneNumber;
	private String address;
	private boolean isActive;
	private List<Account> accounts;
	// other information may be included

	public User() {
	}

	public User(ClientId clientId, String name, String surname, String phoneNumber, String address) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public User(ClientId clientId, String name, String surname, String phoneNumber, String address, boolean isActive) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isActive = isActive;
	}

	public User(Long userId, ClientId clientId, String name, String surname, String phoneNumber, String address,
			boolean isActive, List<Account> accounts) {
		super();
		this.userId = userId;
		this.clientId = clientId;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isActive = isActive;
		this.accounts = accounts;
	}

	public ClientId getClientId() {
		return clientId;
	}

	public void setClientId(ClientId clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUserId() {
		return userId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
