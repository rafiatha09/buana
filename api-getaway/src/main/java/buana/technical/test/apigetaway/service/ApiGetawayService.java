package buana.technical.test.apigetaway.service;

import buana.technical.test.apigetaway.dto.AddProductDTO;
import buana.technical.test.apigetaway.dto.GetProductDTO;
import buana.technical.test.apigetaway.dto.ProductDTO;
import buana.technical.test.apigetaway.dto.RequestOrderDTO;
import buana.technical.test.apigetaway.dto.ResponseOrderDTO;
import buana.technical.test.apigetaway.dto.RestockProductDTO;

public interface ApiGetawayService {
    void addProductToInventory(AddProductDTO addProductDTO);

    ProductDTO restockProductQuantity(Long idProduct ,RestockProductDTO restockProductDTO);
    
    GetProductDTO productValidation(Long idProduct, Long idInventory);

    ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO);
}
