package com.zampro.banco.cuenta.entities;

import java.util.Date;

public class Transaction {
	
	private Long id;

    private String detail;
    private Long originAccount;
    private Long destinationAccount;
    private Double amount;
    private Date date;
    private Long idAccount;
    private Integer typeTransaction;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(Long originAccount) {
		this.originAccount = originAccount;
	}
	public Long getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(Long destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public Integer getTypeTransaction() {
		return typeTransaction;
	}
	public void setTypeTransaction(Integer typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
}
