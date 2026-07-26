package com.springboot.web.security.Controller;

import java.util.List;

import org.springframework.transaction.TransactionStatus;

import com.springboot.web.security.Model.Transaction;
public class TransactionRequest {
	private List<Transaction> transactionData;
    private List<TransactionStatus> transactionStatusData;
	public List<Transaction> getTransactionData() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<com.springboot.web.security.Model.TransactionStatus> getTransactionStatusData() {
		// TODO Auto-generated method stub
		return null;
	}
}
