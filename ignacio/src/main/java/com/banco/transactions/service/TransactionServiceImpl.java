package com.banco.transactions.service;

import com.banco.transactions.entity.Transaction;
import com.banco.transactions.exceptions.BadRequest;
import com.banco.transactions.repository.Itransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements ITransactionService {


    @Autowired
    private Itransaction itransaction;

    @Override
    public Transaction getId(Long id){

        Transaction t = itransaction.findById(id).orElse(null);
        if(t != null){
            return t;
        }else{
            throw new BadRequest(id);
        }
    }
    @Override
    public List<Transaction> getAll(){
        List<Transaction> list = itransaction.findAll();
        return list;
    }
    @Override
    public Transaction createTransaction(Transaction transaction) {

        Double amount = transaction.getAmount() * transaction.getTypeTransaction();
        transaction.setAmount(amount);
        itransaction.save(transaction);
        return transaction;
    }
}
