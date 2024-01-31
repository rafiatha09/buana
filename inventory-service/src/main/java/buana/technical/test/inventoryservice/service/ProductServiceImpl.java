package buana.technical.test.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buana.technical.test.inventoryservice.model.Product;
import buana.technical.test.inventoryservice.repository.InventoryDb;
import buana.technical.test.inventoryservice.repository.ProductDb;
import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDb productDb;

    @Autowired
    InventoryDb inventoryDb;

    @Override
    public void saveProduct(Product product){
        productDb.save(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productDb.findAll();
    }

    @Override
    public Product getProductById(Long productId){
        List<Product> products = productDb.findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == productId){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean isProductInInventory(Long productId, Long inventoryId){
        Product product = getProductById(productId);
        if (product == null){
            return false;
        }
        return product.getInventory().getIdInventory() == inventoryId ? true: false;
    }

    @Override
    public Product restockProduct(Long productId, BigDecimal quantityToAdd) {
        Product product = getProductById(productId);
        product.setQuantity(product.getQuantity().add(quantityToAdd));
        saveProduct(product);
        return product;
    }
    @Override
    public Product purchaseProduct(Long productId, BigDecimal quantityToSub) {
        Product product = getProductById(productId);
        product.setQuantity(product.getQuantity().subtract(quantityToSub));
        saveProduct(product);
        return product;
    }

    @Override
    public boolean validateProductQuantity(Long productId, BigDecimal quantityToOrder){
        Product product = getProductById(productId);
        if (product.getQuantity().compareTo(quantityToOrder) >= 0) {
            purchaseProduct(productId, quantityToOrder);
            return true;
        }
        return false;
    }
}
