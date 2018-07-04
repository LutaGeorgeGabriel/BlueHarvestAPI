package application.service;

import application.model.Account;
import application.model.Transaction;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    @Autowired
    TransactionService transactionService;

    public Account create(User user, double initialCredit) {
        Account account = new Account(user, 0.0);
        if(initialCredit != 0) {
            Transaction transaction = transactionService.create(account, account, initialCredit);
            account.addTransaction(transaction);
        }
        return account;
    }

}
