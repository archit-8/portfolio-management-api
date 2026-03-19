package com.example.portfolio.model.dto;

import lombok.Data;

@Data
public class AssetDTO {
    private Long portfolioId;
    private String symbol;
    private Double quantity;
    private Double purchasePrice;
}