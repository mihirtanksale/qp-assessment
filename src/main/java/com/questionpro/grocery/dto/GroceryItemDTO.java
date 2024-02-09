package com.questionpro.grocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroceryItemDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    public GroceryItemDTO(Long id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}