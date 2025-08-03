package com.example.Ecommerce.OrderService.Entity;

import com.example.Ecommerce.OrderService.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order extends BaseEntity{
     private Long userId;
     @Enumerated(EnumType.STRING)
     private OrderStatus status;

     //automatically persists the order items automatically to the order item table
     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//  we have remove ,perssits
     private List<OrderItem> items;


}
