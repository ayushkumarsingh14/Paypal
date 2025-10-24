package com.paypal.transaction_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.repository.TransactionRepo;

@Service
public class TransactionServiceImp implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImp(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Transaction createTransaction(Transaction request) {
        System.out.println("Entered createTransaction");

        Transaction transaction = new Transaction();
        transaction.setSenderId(request.getSenderId());
        transaction.setReceiverId(request.getReceiverId());
        transaction.setAmount(request.getAmount());
        transaction.setTimeStamp(LocalDateTime.now());
        transaction.setStatus("SUCCESS");

        System.out.println("Transaction object: " + transaction);

        Transaction saved = transactionRepo.save(transaction);
        System.out.println("Transaction saved: " + saved);

        return saved;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
}
