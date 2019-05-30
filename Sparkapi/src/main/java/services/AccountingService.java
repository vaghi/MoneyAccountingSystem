package services;

import dao.AccountingDao;
import entities.Transaction;
import entities.TransactionException;
import entities.TransactionType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountingService implements IAccountingService {

    private AccountingDao accountingDao = new AccountingDao();

    @Override
    public List<Transaction> getTransactions() {
        return accountingDao.getTransactions();
    }

    @Override
    public Transaction addTransaction(Transaction transaction) throws TransactionException {
        ValidateNewTransaction(transaction);

        float amountToAdd = transaction.getAmount();
        if(transaction.getType() == TransactionType.debit)
            amountToAdd *= -1;

        accountingDao.modifyAmount(amountToAdd);
        return accountingDao.addTransaction(transaction);
    }

    @Override
    public Transaction getTransactionById(String id) throws TransactionException {
        ValidateTransactionId(id);

        Optional<Transaction> transaction = accountingDao.getTransactionById(id);
        if(transaction.isPresent())
            return transaction.get();
        else
            throw new TransactionException(404, "transaction not found");
    }

    private void ValidateNewTransaction(Transaction transaction) throws TransactionException {
        if(!(transaction.getAmount() > 0) || transaction.getType() == null) {
            throw new TransactionException(400, "invalid input");
        }

        if(transaction.getType().equals(TransactionType.debit) && accountingDao.getCurrentBalance() < transaction.getAmount())
            throw new TransactionException(400, "invalid transaction");
    }

    private void ValidateTransactionId(String id) throws TransactionException {
        try{
            UUID.fromString(id);
        } catch (IllegalArgumentException exception){
            throw new TransactionException(400, "invalid ID supplied");
        }
    }
}
