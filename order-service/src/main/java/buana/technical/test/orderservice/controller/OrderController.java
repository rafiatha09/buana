package buana.technical.test.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import buana.technical.test.orderservice.dto.RequestOrderDTO;
import buana.technical.test.orderservice.model.Order;
import buana.technical.test.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> addProduct(@RequestBody RequestOrderDTO requestOrderDTO){
        Order order = orderService.createOrder(requestOrderDTO);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
