package buana.technical.test.inventoryservice.service;

import buana.technical.test.inventoryservice.model.Inventory;
import java.util.List;

public interface InventoryService {
    
    void saveInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryById(Long inventoryId);

}
