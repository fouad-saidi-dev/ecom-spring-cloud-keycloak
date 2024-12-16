package com.fouadev.inventoryservice;

import com.fouadev.inventoryservice.entities.Product;
import com.fouadev.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Keyboard")
                            .price(100.0)
                            .quantity(10)
                            .build()
            );

            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(1000.0)
                            .quantity(10)
                            .build()
            );

            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Mouse")
                            .price(50.0)
                            .quantity(10)
                            .build()
            );

            productRepository.findAll().forEach(System.out::println);

        };
    }
}
