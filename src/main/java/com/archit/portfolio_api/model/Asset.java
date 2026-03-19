package com.example.portfolio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private com.example.portfolio.model.Portfolio portfolio;
}