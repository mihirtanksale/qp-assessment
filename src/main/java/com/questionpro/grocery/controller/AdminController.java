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
    public void addGroceryItem(@RequestBody GroceryItemDTO itemDTO) {
        adminService.addGroceryItem(itemDTO);
    }

    @GetMapping("/grocery-items")
    public List<GroceryItemDTO> getAllGroceryItems() {
        System.out.println("test");
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/remove-item/{itemId}")
    public void removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
    }

    @PutMapping("/update-item")
    public void updateGroceryItem(@RequestBody GroceryItemDTO itemDTO) {
        adminService.updateGroceryItem(itemDTO);
    }

    @PutMapping("/manage-inventory/{itemId}")
    public void manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        adminService. manageInventory(itemId, quantity);
    }
}
