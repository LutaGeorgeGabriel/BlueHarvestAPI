package application.service;

import application.model.Account;
import application.model.Transaction;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static application.utils.Utils.generateUUID;

public class AccountService {

    @Autowired
    TransactionService transactionService;

    public Account create(User user, double initialCredit) {
        // creating a new user linked account
        Account account = new Account(user.getCustomerID(), generateUUID(), 0.0);

        if(initialCredit != 0) {

            // create mockUser - from which we take the given amount
            User mockUser = new User(generateUUID(), "Rothschild", "Family", new ArrayList<>());

            // create mock account - from which we simulate a withdrawal
            Account mockAccount = new Account(mockUser.getCustomerID(), generateUUID(), 100.0);

            // creating the transaction with the mock account as source and new account as target
            Transaction transaction = transactionService.create(mockAccount, account, initialCredit);

            // simulate withdrawal from a source account
            mockAccount.withdraw(initialCredit);

            // simulate a deposit to the target account
            account.deposit(initialCredit);

            // adding the transaction to the account
            account.addTransaction(transaction);
        }
        return account;
    }
}
