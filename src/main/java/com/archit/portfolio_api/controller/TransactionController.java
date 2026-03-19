package com.example.portfolio.controller;

import com.example.portfolio.model.Transaction;
import com.example.portfolio.model.dto.TransactionDTO;
import com.example.portfolio.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/api/transactions")
    public Transaction create(@RequestBody TransactionDTO dto) {
        return service.createTransaction(dto);
    }

    @GetMapping("/api/portfolios/{id}/transactions")
    public List<Transaction> getByPortfolio(@PathVariable Long id) {
        return service.getTransactionsByPortfolio(id);
    }

    @GetMapping("/api/transactions/{id}")
    public Transaction getById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }
}