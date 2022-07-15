package com.banco.transactions.service;

import com.banco.transactions.entity.Transaction;
import com.banco.transactions.exceptions.BadRequest;
import com.banco.transactions.repository.Itransaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {


    @Autowired
    private Itransaction itransaction;

    @Autowired
    private Transaction transaction;


    public List<Transaction> getAllTransaction(Long id){
        try {
            List<Transaction> list = itransaction.findAll();
            List<Transaction> listById = new ArrayList<Transaction>();

            for (int i = 0; i < list.size(); i++) {
                transaction = list.get(i);
                if (transaction.getIdAccount().equals(id)) {
                    listById.add(list.get(i));
                }
            }
            return listById;
        }catch(Exception BadRequest) {
            throw new BadRequest(id);
        }
}
    public Transaction createTransaction(Transaction transaction){

        Double amount = transaction.getAmount() * transaction.getTypeTransaction();
        transaction.setAmount(amount);

        return transaction;
    }
}
