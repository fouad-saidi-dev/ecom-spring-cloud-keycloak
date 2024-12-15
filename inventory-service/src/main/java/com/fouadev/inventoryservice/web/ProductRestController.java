package com.fouadev.inventoryservice.web;

import com.fouadev.inventoryservice.entities.Product;
import com.fouadev.inventoryservice.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/{id}")
    public Product getProduct(String id) {
        return productRepository.findById(id).get();
    }
}