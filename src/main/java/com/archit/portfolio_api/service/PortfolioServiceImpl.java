package com.example.portfolio.service;

import com.archit.portfolio_api.service.PortfolioService;
import com.example.portfolio.model.Portfolio;
import com.example.portfolio.model.dto.PortfolioDTO;
import com.example.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository repository;

    @Override
    public Portfolio createPortfolio(PortfolioDTO dto) {
        Portfolio p = new Portfolio();
        p.setName(dto.getName());
        return repository.save(p);
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        return repository.findAll();
    }
}