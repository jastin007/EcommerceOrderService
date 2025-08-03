package com.example.Ecommerce.OrderService.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
       private Long productId;
       private int quantity;
}
