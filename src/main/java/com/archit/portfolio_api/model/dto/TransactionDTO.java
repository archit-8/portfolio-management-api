package com.example.portfolio.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long assetId;
    private String type;
    private Double quantity;
    private Double price;
    private LocalDateTime timestamp;
}