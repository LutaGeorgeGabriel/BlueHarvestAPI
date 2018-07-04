package application.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private User user;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    public User getUser() {
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
}
