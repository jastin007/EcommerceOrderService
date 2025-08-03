package com.example.Ecommerce.OrderService.clients;

import com.example.Ecommerce.OrderService.Dto.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
//    private final RestTemplateBuilder restTemplateBuilder;

      private final RestTemplate restTemplate;

      public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
      }

//      public ProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplateBuilder = restTemplateBuilder;
//      }


    public ProductDTO getProductById(Long productId){
//          RestTemplate restTemplate = restTemplateBuilder.build();
          //not the best way > service discovery > netflix eureka
//          String url = "http://localhost:3001/api/products/"+productId;
            String url = "http://ECOMMERCESPRING/api/products/"+productId;
            ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
            return response.getBody();

        //api gateway?? no
       // service > third party server/client
        // service>service --no api gateway needed
    }
}
