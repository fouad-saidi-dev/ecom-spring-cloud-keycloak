package com.fouadev.orderservice;

import com.fouadev.orderservice.entities.Order;
import com.fouadev.orderservice.entities.ProductItem;
import com.fouadev.orderservice.enums.OrderState;
import com.fouadev.orderservice.model.Product;
import com.fouadev.orderservice.repositories.OrderRepository;
import com.fouadev.orderservice.repositories.ProductItemRepository;
import com.fouadev.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(OrderRepository orderRepository,
                             ProductItemRepository productItemRepository,
                             InventoryRestClient inventoryRestClient) {
        return args -> {

            List<Product> products = inventoryRestClient.getProducts();

            for (int i = 0; i < 5; i++) {
                Order order = Order.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDateTime.now())
                        .state(OrderState.PENDING)
                        .build();

                Order savedOrder = orderRepository.save(order);

                products.forEach(p->{

                    ProductItem productItem = ProductItem.builder()
                            .price(p.getPrice())
                            .quantity(new Random().nextInt(20))
                            .productId(p.getId())
                            .order(savedOrder)
                            .build();

                    productItemRepository.save(productItem);

                });
            }

        };
    }
}