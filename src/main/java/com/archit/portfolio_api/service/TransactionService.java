package com.example.portfolio.service;

import com.example.portfolio.model.Transaction;
import com.example.portfolio.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    // Create new transaction (BUY/SELL)
    Transaction createTransaction(TransactionDTO dto);

    // Get all transactions for a portfolio
    List<Transaction> getTransactionsByPortfolio(Long portfolioId);

    // Get single transaction by ID
    Transaction getTransactionById(Long id);
}