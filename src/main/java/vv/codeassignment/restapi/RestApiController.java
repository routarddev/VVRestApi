package vv.codeassignment.restapi;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vv.codeassignment.error.ErrorMessage;
import vv.codeassignment.model.Account;
import vv.codeassignment.model.ClientId;
import vv.codeassignment.model.Transaction;
import vv.codeassignment.model.User;
import vv.codeassignment.service.AccountServiceImpl;
import vv.codeassignment.service.TransactionServiceImpl;
import vv.codeassignment.service.UserServiceImpl;

@RestController
@RequestMapping("/rest-api")
public class RestApiController {

	public static final Logger logger = (Logger) LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserServiceImpl userService;

	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	TransactionServiceImpl transactionService;

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public ResponseEntity<String> retrieveUserName(ClientId clientId) {
		logger.info("Fetching User with email " + clientId.getEmail());
		User user = userService.getClientByClientId(clientId);
		if (user == null) {
			logger.error("User with email {" + clientId.getEmail() + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("User with email " + clientId.getEmail() + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(user.getName(), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> retrieveUser(Long userId) {
		logger.info("Fetching User with id " + userId.toString());
		User user = userService.getClientById(userId);
		if (user == null) {
			logger.error("User with id {" + userId.toString() + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("User with id " + userId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/accounts/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<Account> retrieveAccountInformation(Long accountId) {
		Account account = accountService.getAccountByAccountId(accountId);
		if (account == null) {
			logger.error("Account with id {" + accountId + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Account with id " + accountId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/account/transactions/{accountId}")
	public ResponseEntity<List<Transaction>> retrieveTransactions(Long accountId) {
		List<Transaction> transactionList = accountService.getAllTransactionsByAccountId(accountId);
		if (transactionList == null) {
			logger.error("Transactions with id {" + accountId + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Transactions for accountId " + accountId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		if (transactionList.isEmpty()) {
			logger.info("There are no transactions for account {" + accountId + "}");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("There are no transactions for account " + accountId),
					HttpStatus.OK);
		}
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/accounts/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<Double> retrieveAccountBalance(Long accountId) {
		Account account = accountService.getAccountByAccountId(accountId);
		if (account == null) {
			logger.error("Account with id {" + accountId + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Account with id " + accountId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Double>(account.getCurrentAmount(), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/accounts/{accountId}", method = RequestMethod.PUT)
	public void depositMoney(Long accountId, Double amountToDeposit) {
		Account account = accountService.getAccountByAccountId(accountId);
		if (account == null) {
			logger.error("Account with id {" + accountId + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Account with id " + accountId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		Double amount = account.getCurrentAmount();
		account.setCurrentAmount(amount + amountToDeposit);
		accountService.updateAccount(account);
		Transaction transaction = new Transaction(accountId, account.getCurrentAmount(), amount, amountToDeposit, "Deposit", LocalDateTime.now());
		transactionService.createTransaction(transaction);
		
		//URL redirection may be applied
	}

	@RequestMapping(value = "/user/accounts/{accountId}", method = RequestMethod.PUT)
	public void withdrawMoney(Long accountId, Double amountToWithdraw) {
		Account account = accountService.getAccountByAccountId(accountId);
		if (account == null) {
			logger.error("Account with id {" + accountId + "} not found.");
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Account with id " + accountId + " not found"),
					HttpStatus.NOT_FOUND);
		}
		if (account.getCurrentAmount() < amountToWithdraw) {
			logger.error("Cannot withdraw this amount of money {"+ amountToWithdraw +"}. Current amount: " + account.getCurrentAmount());
			new ResponseEntity<ErrorMessage>(new ErrorMessage("Cannot withdraw this amount of money {"+ amountToWithdraw +"}. Current amount: " + account.getCurrentAmount()),
					HttpStatus.BAD_REQUEST);
		}
		Double amount = account.getCurrentAmount();
		account.setCurrentAmount(amount - amountToWithdraw);
		accountService.updateAccount(account);
		Transaction transaction = new Transaction(accountId, account.getCurrentAmount(), amount, amountToWithdraw, "Withdrawal", LocalDateTime.now());
		transactionService.createTransaction(transaction);
		
		//URL redirection may be applied
	}

}
