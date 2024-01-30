package buana.technical.test.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.repository.InventoryDb;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryDb inventoryDb;
    
    @Override
    public void saveInventory(Inventory inventory){
        inventoryDb.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory(){
       return inventoryDb.findAll();
    }

    @Override
    public Inventory getInventoryById(Long inventoryId){
        List<Inventory> inventories = inventoryDb.findAll();
        for (int i = 0; i < inventories.size(); i++) {
            if (inventories.get(i).getIdInventory() == inventoryId){
                return inventories.get(i);
            }
        }
        return null;
    }
}
