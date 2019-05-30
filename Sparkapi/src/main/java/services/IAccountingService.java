package services;

import entities.Transaction;
import entities.TransactionException;

import java.util.List;

public interface IAccountingService {
    List<Transaction> getTransactions();
    Transaction addTransaction(Transaction transaction) throws TransactionException;
    Transaction getTransactionById(String id) throws TransactionException;
}
