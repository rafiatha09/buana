package buana.technical.test.apigetaway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import buana.technical.test.apigetaway.dto.AddProductDTO;
import buana.technical.test.apigetaway.dto.ProductDTO;
import buana.technical.test.apigetaway.dto.RestockProductDTO;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;


@Service
public class ApiGetawayServiceImpl implements ApiGetawayService{

    // private final WebClient webClientInventory;
    private final WebClient webClientProduct;

    public ApiGetawayServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientProduct = webClientBuilder.baseUrl("http://localhost:8081/api/product").build();
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
    public String productValidation(Long idProduct, Long idInventory){
        return this.webClientProduct
                .get()
                .uri("/"+ idProduct.toString()+"/inventory/" + idInventory.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
