package dao;

import entities.Transaction;

import java.util.List;
import java.util.Optional;

public interface IAccountingDao {
    List<Transaction> getTransactions();
    Transaction addTransaction(Transaction transaction);
    Optional<Transaction> getTransactionById(String id);
    void modifyAmount(float amount);
}
