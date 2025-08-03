package com.example.Ecommerce.OrderService.Service;

import com.example.Ecommerce.OrderService.Dto.CreateOrderResponseDTO;
import com.example.Ecommerce.OrderService.Dto.OrderRequestDTO;

public interface IOrderService {
       CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO);
       String UpdateOrderStatus(OrderRequestDTO requestDTO);
}
