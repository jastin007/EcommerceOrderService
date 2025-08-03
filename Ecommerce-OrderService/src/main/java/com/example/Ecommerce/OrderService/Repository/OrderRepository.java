package com.example.Ecommerce.OrderService.Repository;

import com.example.Ecommerce.OrderService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
