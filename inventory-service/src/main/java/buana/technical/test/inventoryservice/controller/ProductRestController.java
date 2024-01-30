package buana.technical.test.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import buana.technical.test.inventoryservice.dto.ProductMapper;
import buana.technical.test.inventoryservice.dto.request.CreateProductDTO;
import buana.technical.test.inventoryservice.dto.request.PurchaseDTO;
import buana.technical.test.inventoryservice.dto.request.RestockDTO;
import buana.technical.test.inventoryservice.dto.response.GetProductDTO;
import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.model.Product;
import buana.technical.test.inventoryservice.service.InventoryService;
import buana.technical.test.inventoryservice.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private InventoryService inventoryService;

    // GET endpoint to create a new product item
    @PostMapping("/create")
    public ResponseEntity<Product> addProduct(@RequestBody CreateProductDTO productRequest){
        Inventory inventory = inventoryService.getInventoryById(productRequest.getInventoryId());
        Product product = productMapper.productRequestDTOtoProduct(productRequest);
        product.setInventory(inventory);
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // GET endpoint to retrieve all product items
    @GetMapping("/view-all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.CREATED); 
    }

    // GET endpoint to retrieve a single product item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return product != null ? new ResponseEntity<>(product, HttpStatus.OK) 
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT endpoint to restock product item
    @PutMapping("/{id}/restock")
    public ResponseEntity<?> restockProduct(@PathVariable Long id, @RequestBody RestockDTO restockDTO) {
        Product updatedProduct = productService.restockProduct(id, restockDTO.getQuantityToAdd());
        return ResponseEntity.ok(updatedProduct);
    }

    // PUT endpoint to substract product item
    @PutMapping("/{id}/purchase")
    public ResponseEntity<?> purchaseProduct(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO) {
        Product updatedProduct = productService.purchaseProduct(id, purchaseDTO.getQuantityToSub());
        return ResponseEntity.ok(updatedProduct);
    }

    // GET endpoint to validate is product in an inventory
    @GetMapping("/{idProduct}/inventory/{idInventory}")
    public ResponseEntity<?> isProductInInventory(@PathVariable Long idProduct, @PathVariable Long idInventory) {
        boolean isInInventory = productService.isProductInInventory(idProduct, idInventory);
        if (isInInventory) {
            return ResponseEntity.ok().body("Product is in the specified Inventory.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
