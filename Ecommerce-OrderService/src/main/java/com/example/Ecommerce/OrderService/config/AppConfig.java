package com.example.Ecommerce.OrderService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
// adding loadbalanced on a restemplate enables client-side load balancing
// it intercept the local service names and resolve them into actual instances urls from eureka

//eureka client > product_service

//  PRODUCT_SERVICE > [10.0.0.12:8080, 10.0.0.13:8080,10.0.0.14:8080]
//  restTemplate.getForObject("http://PRODUCT-SERVICE/api/products/1",ProductDTO.class);
//PRODUCT_SERVICE > NOT A DNS name
//@LoadBalanced annotation contacts eureka>fetch the available instances > picks one
//restTemplate.getForObject("http://10.0.0.13:8080/api/products/1",ProductDTO.class);