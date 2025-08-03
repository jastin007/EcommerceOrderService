package com.example.Ecommerce.OrderService.Dto;

import com.example.Ecommerce.OrderService.Enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private Long OrderId;
    private OrderStatus status;

}
