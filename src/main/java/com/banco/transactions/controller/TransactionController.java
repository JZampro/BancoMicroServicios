package com.banco.transactions.controller;


import com.banco.transactions.entity.Transaction;
import com.banco.transactions.repository.Itransaction;
import com.banco.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private Itransaction itransaction;

    TransactionService transactionService = new TransactionService();

    Transaction transaction = new Transaction();

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<Transaction> getAllTransactions(){
      return  itransaction.findAll();
    }

    @PostMapping("/postTransaction")
    @ResponseStatus(HttpStatus.OK)
    private void createTransaction(@RequestBody Transaction transaction){

       Transaction transaction1 =  transactionService.createTransaction(transaction);
       itransaction.save(transaction1);

    }

    @GetMapping("/getAll/{id}") //recibo el id de la cuenta "idAccount"
    @ResponseStatus(HttpStatus.OK)
    private List<Transaction> getAllTransactions(@PathVariable Long id){
        return transactionService.getAllTransaction(id);
    }
}
