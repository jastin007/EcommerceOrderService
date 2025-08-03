package com.example.Ecommerce.OrderService.Controller;

import com.example.Ecommerce.OrderService.Dto.CreateOrderResponseDTO;
import com.example.Ecommerce.OrderService.Dto.OrderRequestDTO;
import com.example.Ecommerce.OrderService.Service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
       private final IOrderService orderService;

       public OrderController(IOrderService orderService){
           this.orderService = orderService;
       }

       @PostMapping
       public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){
           CreateOrderResponseDTO order = orderService.createOrder(request);
           return ResponseEntity.ok(order);
       }

       @PatchMapping
       public ResponseEntity<String> UpdatePaymentStatus(@RequestBody OrderRequestDTO request){
          String order = orderService.UpdateOrderStatus(request);
          return ResponseEntity.ok(order);
       }


}
