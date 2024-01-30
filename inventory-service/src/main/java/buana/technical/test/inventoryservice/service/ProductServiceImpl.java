package buana.technical.test.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.model.Product;
import buana.technical.test.inventoryservice.repository.InventoryDb;
import buana.technical.test.inventoryservice.repository.ProductDb;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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
        return productDb.getById(productId);
    }

    @Override
    public Product updateProduct(Product product){
        return productDb.save(product);
    }

    @Override
    public boolean validateProduct(Long inventoryId, Long productId){
       java.util.Optional<Inventory> inventory = inventoryDb.findById(inventoryId);

       System.out.println(inventory);
       return true;
    }
}
