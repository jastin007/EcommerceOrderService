package com.example.Ecommerce.OrderService.Service;

import com.example.Ecommerce.OrderService.Dto.CreateOrderResponseDTO;
import com.example.Ecommerce.OrderService.Dto.OrderItemDto;
import com.example.Ecommerce.OrderService.Dto.OrderRequestDTO;
import com.example.Ecommerce.OrderService.Dto.ProductDTO;
import com.example.Ecommerce.OrderService.Entity.Order;
import com.example.Ecommerce.OrderService.Entity.OrderItem;
import com.example.Ecommerce.OrderService.Mappers.OrderItemMapper;
import com.example.Ecommerce.OrderService.Mappers.OrderMapper;
import com.example.Ecommerce.OrderService.Repository.OrderItemRepository;
import com.example.Ecommerce.OrderService.Repository.OrderRepository;
import com.example.Ecommerce.OrderService.clients.ProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
//    private final OrderItemRepository orderItemRepository;

    private final ProductServiceClient productClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productClient){
        this.orderRepository=orderRepository;
        this.productClient = productClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        Order order = OrderMapper.toOrder(requestDTO);

       Order savedorder = orderRepository.save(order);
        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDto itemDto: requestDTO.getItems()){
            ProductDTO product = productClient.getProductById(itemDto.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit*itemDto.getProductId();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
              itemDto,
              order,
              pricePerUnit,
              totalPrice
            );
            items.add(item);
        }

             order.setItems(items);
//             orderRepository.saveAll()
             Order createdOrder = orderRepository.save(order);
             return OrderMapper.orderResponseDTO(createdOrder);
//        return OrderMapper.orderResponseDTO(savedorder);
    }

    @Override
    public String UpdateOrderStatus(OrderRequestDTO requestDTO) {
        Order order = OrderMapper.toOrder(requestDTO);
        Order savedorder = orderRepository.save(order);
        return "Updated successfully";
    }




}
