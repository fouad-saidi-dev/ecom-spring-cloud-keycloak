package com.fouadev.orderservice.model;

import lombok.*;



@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}