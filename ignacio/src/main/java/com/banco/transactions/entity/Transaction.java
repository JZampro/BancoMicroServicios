package com.banco.transactions.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;
    private Long originAccount;
    private Long destinationAccount;
    private Double amount;
    private Date date;
    private Long idAccount;
    private Integer typeTransaction;

    public Transaction() {
    }

    public Transaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    public Long getOriginAccount() {
        return originAccount;
    }

    public Long getDestinationAccount() {
        return destinationAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public Integer getTypeTransaction() {
        return typeTransaction;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setOriginAccount(Long originAccount) {
        this.originAccount = originAccount;
    }

    public void setDestinationAccount(Long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public void setTypeTransaction(Integer typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", originAccount=" + originAccount +
                ", destinationAccount=" + destinationAccount +
                ", amount=" + amount +
                ", date=" + date +
                ", idAccount=" + idAccount +
                ", typeTransaction=" + typeTransaction +
                '}';
    }
}
