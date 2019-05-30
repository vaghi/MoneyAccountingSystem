package dao;

import entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountingDao implements IAccountingDao {

    private List<Transaction> transactions = new ArrayList<>();
    private float currentBalance = 0;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction addTransaction(Transaction transaction) {
        String newId = UUID.randomUUID().toString();

        Transaction newTransaction = new Transaction(newId, transaction.getType(), transaction.getAmount());
        transactions.add(newTransaction);

        return newTransaction;
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactions.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public void modifyAmount(float amount) {
        currentBalance += amount;
    }

    public float getCurrentBalance() { return this.currentBalance; }
}
