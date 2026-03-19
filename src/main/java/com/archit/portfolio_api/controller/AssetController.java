package com.example.portfolio.controller;

import com.example.portfolio.model.Portfolio;
import com.example.portfolio.model.dto.PortfolioDTO;
import com.example.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService service;

    @PostMapping
    public Portfolio create(@RequestBody PortfolioDTO dto) {
        return service.createPortfolio(dto);
    }

    @GetMapping
    public List<Portfolio> getAll() {
        return service.getAllPortfolios();
    }

    @GetMapping("/{id}")
    public Portfolio getById(@PathVariable Long id) {
        return service.getPortfolioById(id);
    }

    @PutMapping("/{id}")
    public Portfolio update(@PathVariable Long id, @RequestBody PortfolioDTO dto) {
        return service.updatePortfolio(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePortfolio(id);
        return "Portfolio deleted successfully";
    }
}