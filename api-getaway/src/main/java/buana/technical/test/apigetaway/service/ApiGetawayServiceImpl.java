package buana.technical.test.apigetaway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import buana.technical.test.apigetaway.dto.AddProductDTO;
import buana.technical.test.apigetaway.dto.GetProductDTO;
import buana.technical.test.apigetaway.dto.ProductDTO;
import buana.technical.test.apigetaway.dto.RequestOrderDTO;
import buana.technical.test.apigetaway.dto.ResponseOrderDTO;
import buana.technical.test.apigetaway.dto.ResponseProductDTO;
import buana.technical.test.apigetaway.dto.RestockProductDTO;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Service
public class ApiGetawayServiceImpl implements ApiGetawayService{

    private final WebClient webClientProduct;
    private final WebClient webClientOrder;

    public ApiGetawayServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientProduct = webClientBuilder.baseUrl("http://localhost:8081/api/product").build();
        this.webClientOrder = webClientBuilder.baseUrl("http://localhost:8082/api/order").build();
    }
    
    @Override
    public void addProductToInventory(AddProductDTO addProductDTO){
        this.webClientProduct
                .post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(addProductDTO)
                .retrieve()
                .bodyToMono(AddProductDTO.class)
                .block();

    }

    @Override
    public ProductDTO restockProductQuantity(Long idProduct, RestockProductDTO restockProductDTO){
        return this.webClientProduct
                .put()
                .uri("/"+ idProduct.toString() + "/restock")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(restockProductDTO)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public GetProductDTO productValidation(Long idProduct, Long idInventory) {
        try {
            return this.webClientProduct
                    .get()
                    .uri("/" + idProduct.toString() + "/inventory/" + idInventory.toString())
                    .retrieve()
                    .onStatus(HttpStatus.NOT_FOUND::equals, clientResponse -> {
                        return Mono.error(new WebClientResponseException(
                            HttpStatus.NOT_FOUND.value(),
                            "Product not found",
                            null, null, null));
                    })
                    .bodyToMono(GetProductDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("An error occurred while validating the product: " + e.getMessage(), e);
        }
    }

    @Override 
    public ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO){
        return this.webClientOrder
            .post()
            .uri("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestOrderDTO)
            .retrieve()
            .bodyToMono(ResponseOrderDTO.class)
            .block();
    }

}
