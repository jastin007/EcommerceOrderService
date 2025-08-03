package com.example.Ecommerce.OrderService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="OrderItems")
public class OrderItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private int quantity;

    private double pricePerUnit;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
