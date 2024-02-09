package com.questionpro.grocery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroceryOrderDTO {
    private Long itemId;
    private int quantity;

    public GroceryOrderDTO(Long itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}