package application.model;

import java.util.UUID;

// Lombok / Groovy ?
public class Transaction {

    private UUID fromAccount;
    private UUID toAccount;
    private UUID uuid;
    private Long timestamp;
    private double amount;

    public Transaction(UUID fromAccount, UUID toAccount, UUID uuid, Long timestamp, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.uuid = uuid;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public UUID getFromAccount() {
        return this.fromAccount;
    }

    public UUID getToAccount() {
        return this.toAccount;
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
