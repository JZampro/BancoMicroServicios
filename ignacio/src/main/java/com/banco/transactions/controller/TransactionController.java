package com.banco.transactions.controller;


import com.banco.transactions.entity.Transaction;
import com.banco.transactions.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    ITransactionService iTransactionService;

    @GetMapping(path = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<Transaction> getAllTransactions(){
      return  iTransactionService.getAll();
    }

    @PostMapping("/postTransaction")
    @ResponseStatus(HttpStatus.OK)
    private Transaction createTransaction(@RequestBody Transaction transaction){

       Transaction transaction1 =  iTransactionService.createTransaction(transaction);

        return transaction1;
    }


        @GetMapping(path = "/getId/{id}") // "idAccount"
        @ResponseStatus(HttpStatus.OK)
        private Transaction getAllTransaction (@PathVariable Long id){
        return iTransactionService.getId(id);
    }

}
