package com.questionpro.grocery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grocery_order")
@Getter
@Setter
@NoArgsConstructor
public class GroceryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private GroceryItem item;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderHistory order;

    public GroceryOrder(GroceryItem item, Integer quantity, OrderHistory order) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.order = order;
    }
}
