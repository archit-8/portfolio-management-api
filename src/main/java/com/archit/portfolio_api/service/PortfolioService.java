package com.archit.portfolio_api.service;

import com.example.portfolio.model.Portfolio;
import com.example.portfolio.model.dto.PortfolioDTO;

import java.util.List;

public interface PortfolioService {
    Portfolio getPortfolioById(Long id);
    Portfolio updatePortfolio(Long id, PortfolioDTO dto);
    void deletePortfolio(Long id);
}