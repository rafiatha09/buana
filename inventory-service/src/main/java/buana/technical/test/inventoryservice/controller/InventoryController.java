package buana.technical.test.inventoryservice.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import buana.technical.test.inventoryservice.model.Inventory;
import buana.technical.test.inventoryservice.service.InventoryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @PostMapping("inventory/create")
    public void addInventory(@Valid @ModelAttribute Inventory inventory, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else{
            inventoryService.saveInventory(inventory);
        }
        
    }
}