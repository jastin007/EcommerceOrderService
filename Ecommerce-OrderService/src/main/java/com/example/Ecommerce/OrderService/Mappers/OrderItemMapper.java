package com.example.Ecommerce.OrderService.Mappers;

import com.example.Ecommerce.OrderService.Dto.OrderItemDto;
import com.example.Ecommerce.OrderService.Entity.Order;
import com.example.Ecommerce.OrderService.Entity.OrderItem;

public class OrderItemMapper {
    public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemDto itemDto, Order order, double pricePerUnit,
                                     double totalPrice){
        return OrderItem.builder()
                .productId(itemDto.getProductId())
                .quantity(itemDto.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
