package com.questionpro.grocery.service;

import com.questionpro.grocery.dto.GroceryItemDTO;

import java.util.List;

public interface AdminService {
    void addGroceryItem(GroceryItemDTO itemDTO);
    List<GroceryItemDTO> getAllGroceryItems();
    void removeGroceryItem(Long itemId);
    void updateGroceryItem(GroceryItemDTO itemDTO);
    void manageInventory(Long itemId, int quantity);
}
