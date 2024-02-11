package com.questionpro.grocery.controller;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-item")
    public String addGroceryItem(@RequestBody GroceryItemDTO itemDTO) {
        return adminService.addGroceryItem(itemDTO);
    }

    @GetMapping("/grocery-items")
    public List<GroceryItemDTO> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/remove-item/{itemId}")
    public String removeGroceryItem(@PathVariable Long itemId) {
        return adminService.removeGroceryItem(itemId);
    }

    @PutMapping("/update-item")
    public String updateGroceryItem(@RequestBody GroceryItemDTO itemDTO) {
        return adminService.updateGroceryItem(itemDTO);
    }

    @PutMapping("/manage-inventory/{itemId}")
    public String manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        return adminService. manageInventory(itemId, quantity);
    }
}
