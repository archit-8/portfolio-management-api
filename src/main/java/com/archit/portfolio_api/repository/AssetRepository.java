package com.example.portfolio.repository;

import com.example.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Portfolio, Long> {
}