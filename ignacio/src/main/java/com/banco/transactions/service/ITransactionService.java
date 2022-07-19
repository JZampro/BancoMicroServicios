package com.banco.transactions.service;

import com.banco.transactions.entity.Transaction;

import java.util.List;

public interface ITransactionService {

    public List<Transaction> getAll();

    public Transaction getId(Long id);

    public Transaction createTransaction(Transaction t);

}
