package com.fouadev.inventoryservice;

import com.fouadev.inventoryservice.entities.Product;
import com.fouadev.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("Phone").price(100.0).quantity(10).build());
            productRepository.save(Product.builder().name("Tablet").price(50.0).quantity(20).build());
            productRepository.save(Product.builder().name("Laptop").price(500.0).quantity(5).build());
        };
    }
}
