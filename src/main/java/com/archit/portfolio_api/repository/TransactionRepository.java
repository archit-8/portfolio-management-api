package com.example.portfolio.repository;

import com.example.portfolio.model.Portfolio;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Portfolio, Long> {
    List<Transaction> findByAssetPortfolioId(Long portfolioId);
}