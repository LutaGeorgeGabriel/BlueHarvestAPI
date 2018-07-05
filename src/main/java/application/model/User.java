package application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// tip: maybe use Lombok (or refactor in Groovy) for generating getters and setters
public class User {

    private UUID customerID;
    private String name;
    private String surname;
    private List<Account> accounts = new ArrayList<>();

    // needed for serialization
    public User() {
    }

    public User(UUID customerID, String name, String surname, List<Account> accounts) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "User{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
