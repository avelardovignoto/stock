package com.api.stockproduct.controllers;

import com.api.stockproduct.dtos.ProductDTO;
import com.api.stockproduct.entities.Product;
import com.api.stockproduct.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.api.stockproduct.utils.Messages.MESSAGE_1;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> registerProduct(@RequestBody ProductDTO productDTO) {
        productService.registerProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_1.getDescription());
    }

    @GetMapping()
    public ResponseEntity <List<Product>> getProduct(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        List<Product> products = productService.getProduct(pageNumber, pageSize);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
