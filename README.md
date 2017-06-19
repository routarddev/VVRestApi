# VVRestApi
Simple Rest API (WIP)

Backend for a simple "banking" application with the following requirements:
* Client should be able to sign up with email & password
* Client should be able to deposit money
* Client should be able to withdraw money
* Client should be able to see account balance and statement

Basic Data Model:
- User: identified by userId (database automatic and incremental generation) or by ClientId, that is, by email and password. User can have different accounts.
- Account: identified by accountId (database automatic and incremental generation) and related to a specific User(by userId and ClientId). Account will have an historic of transactions.
- Transaction: identified by transactionId (database automatic and incremental generation) and related to a specific account (by accountId). Each transaction provides information about the transaction type ("Deposit", "Withdraw", etc. To be improved by TransactionTypeEnum), the current amount, the previous amount (can be the same if no changes were done), the transaction amount (if it applies) and the transaction date and time.
