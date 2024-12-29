package com.fouadev.orderservice.web;

import com.fouadev.orderservice.entities.Order;
import com.fouadev.orderservice.repositories.OrderRepository;
import com.fouadev.orderservice.restClients.InventoryRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;
    public OrderRestController(OrderRepository orderRepository, InventoryRestClient inventoryRestClient) {
        this.orderRepository = orderRepository;
        this.inventoryRestClient = inventoryRestClient;
    }
    @GetMapping("")
    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(o -> {
            o.getProductItemList().forEach(p -> {
                p.setProduct(inventoryRestClient.getProduct(p.getProductId()));
            });
        });
        return orders;
    }
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.getProductItemList().forEach(p -> {
            p.setProduct(inventoryRestClient.getProduct(p.getProductId()));
        });
        return order;
    }
}