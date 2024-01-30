package buana.technical.test.inventoryservice.service;

import java.util.List;

import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.model.Product;

public interface ProductService {
    
    void saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product updateProduct(Product product);

    boolean validateProduct(Long inventoryId, Long productId);
}
