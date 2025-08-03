package com.example.Ecommerce.OrderService.Mappers;

import com.example.Ecommerce.OrderService.Dto.CreateOrderResponseDTO;
import com.example.Ecommerce.OrderService.Dto.OrderItemDto;
import com.example.Ecommerce.OrderService.Dto.OrderRequestDTO;
import com.example.Ecommerce.OrderService.Entity.Order;
import com.example.Ecommerce.OrderService.Entity.OrderItem;
import com.example.Ecommerce.OrderService.Enums.OrderStatus;

import java.util.stream.Collectors;

public class OrderMapper {
    public static CreateOrderResponseDTO orderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .OrderId(order.getId())
                .status(order.getStatus())
                .build();
    }
//    public static Order toOrder(OrderRequestDTO requestDTO){
//        return Order.builder()
//                .userId(requestDTO.getUserId())
//                .status(OrderStatus.PENDING)
//                .items(requestDTO.getItems().stream()
//                        .map(OrderMapper::toOrderItem)
//                        .collect(Collectors.toList()))
//                        .build();
//    }
    public static Order toOrder(OrderRequestDTO requestDTO){
         return Order.builder()
            .userId(requestDTO.getUserId())
            .status(OrderStatus.PENDING)
                    .build();
    }

//    public static OrderItem toOrderItem(OrderItemDto dto){
//           return com.example.Ecommerce.OrderService.Entity.OrderItem.builder()
//                   .productId(dto.getProductId())
//                   .quantity(dto.getQuantity())
//                   .build();
//    }
}
