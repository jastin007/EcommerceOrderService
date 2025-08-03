package com.example.Ecommerce.OrderService.Dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO {
    // we will fetch the userid from authorization token
    private Long userId;
    private List<OrderItemDto> items;

}
