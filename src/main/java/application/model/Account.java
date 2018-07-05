package application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Lombok / Groovy ?
public class Account {

    // used user UUID to link account to user
    private UUID user;
    private UUID accountID;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(UUID user, UUID accountID, double balance) {
        this.user = user;
        this.accountID = accountID;
        this.balance = balance;
    }

    public UUID getAccountID() {
        return accountID;
    }

    public UUID getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
