package buana.technical.test.orderservice.service;

import buana.technical.test.orderservice.dto.RequestOrderDTO;
import buana.technical.test.orderservice.model.Order;

public interface OrderService {
    Order createOrder(RequestOrderDTO requestOrderDTO);
}
