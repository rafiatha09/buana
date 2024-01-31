package buana.technical.test.apigetaway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import buana.technical.test.apigetaway.dto.AddProductDTO;
import buana.technical.test.apigetaway.dto.GetProductDTO;
import buana.technical.test.apigetaway.dto.ProductDTO;
import buana.technical.test.apigetaway.dto.RequestOrderDTO;
import buana.technical.test.apigetaway.dto.RestockProductDTO;
import buana.technical.test.apigetaway.service.ApiGetawayService;

@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    @Autowired
    private ApiGetawayService apiGetawayService;

    @PostMapping("/add-product")
    public void addProduct(@RequestBody AddProductDTO addProductDTO){
        apiGetawayService.addProductToInventory(addProductDTO);
    }

    @PutMapping("/restock-product/{id}")
    public ResponseEntity<?> restockProduct(@PathVariable Long id, @RequestBody RestockProductDTO restockProductDTO) {
        ProductDTO productDTO = apiGetawayService.restockProductQuantity(id, restockProductDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{idProduct}/inventory/{idInventory}")
    public ResponseEntity<?> isProductInInventory(@PathVariable Long idProduct, @PathVariable Long idInventory) {
        GetProductDTO productDTO = apiGetawayService.productValidation(idProduct, idInventory);
        return new ResponseEntity<>(productDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add-order")
    public ResponseEntity<?> addOrder(@RequestBody RequestOrderDTO requestOrderDTO){
        return new ResponseEntity<>(apiGetawayService.createOrder(requestOrderDTO), HttpStatus.ACCEPTED);
    }
}
