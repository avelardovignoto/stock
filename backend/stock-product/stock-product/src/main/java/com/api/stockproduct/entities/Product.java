package com.api.stockproduct.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private UUID code;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "createdAt")
    private LocalDate createdAt;

}
