package entities;

import java.time.Instant;

public class Transaction {

    public Transaction(String id, TransactionType type, float amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.effectiveDate = Instant.now();
    }

    private String id;
    private TransactionType type;
    private float amount;
    private Instant effectiveDate;

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public TransactionType getType() { return this.type; }
    public void setType(TransactionType type) { this.type = type; }

    public float getAmount() { return this.amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public Instant getEffectiveDate() { return this.effectiveDate; }
    public void setEffectiveDate(Instant effectiveDate) { this.effectiveDate = effectiveDate; }
}
