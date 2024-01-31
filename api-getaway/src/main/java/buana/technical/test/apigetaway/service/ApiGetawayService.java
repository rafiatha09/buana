package buana.technical.test.apigetaway.service;

import buana.technical.test.apigetaway.dto.AddProductDTO;
import buana.technical.test.apigetaway.dto.ProductDTO;
import buana.technical.test.apigetaway.dto.RestockProductDTO;

public interface ApiGetawayService {
    void addProductToInventory(AddProductDTO addProductDTO);

    ProductDTO restockProductQuantity(Long idProduct ,RestockProductDTO restockProductDTO);
    
    String productValidation(Long idProduct, Long idInventory);
}
