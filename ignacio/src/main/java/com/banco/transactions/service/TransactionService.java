package com.banco.transactions.service;

import com.banco.transactions.entity.Transaction;
import com.banco.transactions.exceptions.BadRequest;
import com.banco.transactions.repository.Itransaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionService {


    @Autowired
    private Itransaction itransaction;

    {/*
        public List<Transaction> getIds (Long id){
        try {
            List<Transaction> list = itransaction.findAll();
            List<Transaction> listById = new ArrayList<Transaction>();

            for (int i = 0; i < 5; i++) {
                Transaction transaction1 = list.get(i);
                if (transaction1.getIdAccount().equals(id)) {
                    listById.add(transaction1);
                }
            }
            return listById;
        } catch (Exception BadRequest) {
            throw new BadRequest(id);

    }
    }
     */}
    public List<Transaction> getAllTransaction(){
            List<Transaction> list = itransaction.findAll();
            return list;
        }
    public Transaction createTransaction(Transaction transaction) {

        Double amount = transaction.getAmount() * transaction.getTypeTransaction();
        transaction.setAmount(amount);

        return transaction;
    }
}
