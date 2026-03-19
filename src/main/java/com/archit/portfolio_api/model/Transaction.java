package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // BUY / SELL
    private Double amount;

    @ManyToOne
    private com.example.portfolio.model.Asset asset;
}