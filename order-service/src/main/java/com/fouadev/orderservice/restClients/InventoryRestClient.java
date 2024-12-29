package com.fouadev.orderservice.restClients;

import com.fouadev.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081",name = "inventory-service")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    List<Product> getProducts();
    @GetMapping("/api/products/{productId}")
    Product getProduct(@PathVariable String productId);
}
