package com.fouadev.inventoryservice.web;
/*
 Created by : Fouad SAIDI on 16/12/2024
 @author : Fouad SAIDI
 @date : 16/12/2024
 @project : ecom-spring-cloud-security
*/

import com.fouadev.inventoryservice.entities.Product;
import com.fouadev.inventoryservice.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}