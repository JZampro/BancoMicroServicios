package com.banco.transactions.repository;

import com.banco.transactions.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Itransaction extends JpaRepository<Transaction, Long> {
}
