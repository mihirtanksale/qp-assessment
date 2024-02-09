package com.questionpro.grocery.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "order_history")
@Getter
@Setter
@NoArgsConstructor
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "total_amount")
    private Double totalAmount;

    public OrderHistory(Long orderId, Double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }
}
