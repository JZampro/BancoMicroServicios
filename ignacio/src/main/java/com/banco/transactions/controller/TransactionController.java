package com.banco.transactions.controller;


import com.banco.transactions.entity.Transaction;
import com.banco.transactions.repository.Itransaction;
import com.banco.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final static Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private Itransaction itransaction;

    TransactionService transactionService = new TransactionService();

    Transaction transaction = new Transaction();

    @GetMapping(path = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<Transaction> getAllTransactions(){
      return  itransaction.findAll();
    }

    @PostMapping("/postTransaction")
    @ResponseStatus(HttpStatus.OK)
    private String createTransaction(@RequestBody Transaction transaction){

       Transaction transaction1 =  transactionService.createTransaction(transaction);
       itransaction.save(transaction1);
        return transaction1.toString();
    }

    {/*
        @GetMapping(path = "/getAll/{id}") // "idAccount"
        @ResponseStatus(HttpStatus.OK)
        private List<Transaction> getAllTransaction (@PathVariable Long id){
        return transactionService.getIds(id);
    }
    */}
}
