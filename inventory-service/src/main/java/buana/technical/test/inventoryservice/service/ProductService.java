package buana.technical.test.inventoryservice.service;

import java.util.List;
import java.math.BigDecimal;
import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.model.Product;

public interface ProductService {
    
    void saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    boolean isProductInInventory(Long productId, Long inventoryId);

    Product restockProduct(Long productId, BigDecimal quantityToAdd);

    Product purchaseProduct(Long productId, BigDecimal quantityToSub);
}
