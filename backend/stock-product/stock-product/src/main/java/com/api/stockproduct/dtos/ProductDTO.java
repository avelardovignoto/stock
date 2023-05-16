package com.api.stockproduct.dtos;

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
public class ProductDTO {
    private Long id;
    private UUID code;
    private String productName;
    private Integer quantity;
    private String supplier;
    private LocalDate createdAt;
}
