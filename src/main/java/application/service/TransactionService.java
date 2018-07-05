package application.service;

import application.model.Account;
import application.model.Transaction;

import java.util.Date;

import static application.utils.Utils.generateUUID;

public class TransactionService {

    public Transaction create(Account from, Account to, double amount) {
        // here, from account is just a mock-up in order to simulate a withdrawal
        return new Transaction(from.getAccountID(), to.getAccountID(), generateUUID(), new Date().getTime(), amount);
    }
}
