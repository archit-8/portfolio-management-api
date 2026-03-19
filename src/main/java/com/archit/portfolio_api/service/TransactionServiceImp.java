package com.archit.portfolio_api.service;

import com.example.portfolio.model.Portfolio;
import jakarta.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements com.example.portfolio.service.TransactionService {

    private final com.example.portfolio.repository.TransactionRepository txRepo;
    private final com.example.portfolio.repository.AssetRepository assetRepo;

    @Override
    public com.example.portfolio.model.Transaction createTransaction(com.example.portfolio.model.dto.TransactionDTO dto) {
        Portfolio asset = assetRepo.findById(dto.getAssetId())
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        com.example.portfolio.model.Transaction tx = new com.example.portfolio.model.Transaction();
        tx.setType(dto.getType());
        tx.setQuantity(dto.getQuantity());
        tx.setPrice(dto.getPrice());
        tx.setTimestamp(dto.getTimestamp());
        tx.setAsset(asset);

        return txRepo.save(tx);
    }

    @Override
    public List<Transaction> getTransactionsByPortfolio(Long portfolioId) {
        return txRepo.findByAssetPortfolioId(portfolioId);
    }

    @Override
    public com.example.portfolio.model.Transaction getTransactionById(Long id) {
        return txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}