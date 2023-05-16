package com.api.stockproduct.utils;

import com.api.stockproduct.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private ProductDTO product;
    private String message;
}
