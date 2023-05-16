package com.api.stockproduct.services;

import com.api.stockproduct.dtos.ProductDTO;
import com.api.stockproduct.entities.Product;
import com.api.stockproduct.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void registerProduct(ProductDTO productDTO) {
        var product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setCode(UUID.randomUUID());
        product.setCreatedAt(LocalDate.now());
        productRepository.save(product);
    }

    public List<Product> getProduct(int pageNumber, int pageSize) {
        return productRepository.findAll();
    }

}
