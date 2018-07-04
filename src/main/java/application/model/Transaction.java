package application.model;

import java.util.UUID;

public class Transaction {

    private Account from;
    private Account to;
    private UUID uuid;
    private Long timestamp;
    private double amount;

    public Transaction(Account from, Account to, UUID uuid, Long timestamp, double amount) {
        this.from = from;
        this.to = to;
        this.uuid = uuid;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
