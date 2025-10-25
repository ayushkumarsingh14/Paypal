package com.paypal.transaction_service.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.paypal.transaction_service.entity.Transaction;

@Component
public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
}
