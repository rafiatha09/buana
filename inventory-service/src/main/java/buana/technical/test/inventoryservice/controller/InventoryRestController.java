package buana.technical.test.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.bind.annotation.*;
import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory") // Base path for all endpoints in this controller
public class InventoryRestController {

    @Autowired
    private InventoryService inventoryService;

    // GET endpoint to retrieve all inventory items
    @GetMapping(value = "/view-all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventories = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    // POST endpoint to create a new inventory item
    @PostMapping("/create")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
        return new ResponseEntity<>(inventory, HttpStatus.CREATED);
    }

    // GET endpoint to retrieve a single inventory item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Inventory inventory = inventoryService.getInventoryById(id);
        return inventory != null ? new ResponseEntity<>(inventory, HttpStatus.OK) 
                                 : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
