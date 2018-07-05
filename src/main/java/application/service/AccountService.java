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
        Account account = new Account(user.getCustomerID(), generateUUID(), 0.0);
        if(initialCredit != 0) {

            // create mockUser - from which we take money
            User mockUser = new User(generateUUID(), "Rothschild", "Family", new ArrayList<>());

            // create mock account - from which we simulate a withdrawal
            Account mockAccount = new Account(mockUser.getCustomerID(), generateUUID(), 100.0);

            Transaction transaction = transactionService.create(mockAccount, account, initialCredit);
            mockAccount.withdraw(initialCredit);
            account.deposit(initialCredit);

            account.addTransaction(transaction);
        }
        return account;
    }

}
