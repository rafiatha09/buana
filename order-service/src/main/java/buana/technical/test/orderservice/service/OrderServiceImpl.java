package buana.technical.test.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import buana.technical.test.orderservice.dto.RequestOrderDTO;
import buana.technical.test.orderservice.dto.ResponseProductDTO;
import buana.technical.test.orderservice.model.Order;
import buana.technical.test.orderservice.repository.OrderDb;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    OrderDb orderDb;

    private final WebClient webClientProduct;

    public OrderServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientProduct = webClientBuilder.baseUrl("http://localhost:8081/api/product").build();
    }

    @Override
    public Order createOrder(RequestOrderDTO requestOrderDTO) {
        ResponseProductDTO responseProductDTO;
        try {
            responseProductDTO = this.webClientProduct
                    .get()
                    .uri("/" + requestOrderDTO.getIdProduct().toString())
                    .retrieve()
                    .onStatus(HttpStatus.NOT_FOUND::equals, clientResponse -> {
                        return Mono.error(new WebClientResponseException(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Product does not exist",
                            null, null, null));
                    })
                    .bodyToMono(ResponseProductDTO.class)
                    .block();
            String isSufficient = this.webClientProduct
                .get()
                .uri("/" + requestOrderDTO.getIdProduct().toString() + "/quantity/" + requestOrderDTO.getQuantity().toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        
            if (isSufficient.equals("Sufficient quantity available for the product.")) {
                Order order = new Order();
                order.setQuantity(requestOrderDTO.getQuantity());
                order.setIdProduct(requestOrderDTO.getIdProduct());
                return orderDb.save(order);
            } else {
                throw new RuntimeException("Insufficient quantity for the product with ID " + requestOrderDTO.getIdProduct());
            }
        }
        catch (WebClientResponseException e) {
            throw new RuntimeException("Product with ID " + requestOrderDTO.getIdProduct() + " does not exist.", e);
        }
    }
    

}
