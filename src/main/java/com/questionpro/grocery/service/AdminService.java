package com.questionpro.grocery.service;

import com.questionpro.grocery.dto.GroceryItemDTO;

import java.util.List;

public interface AdminService {
    String addGroceryItem(GroceryItemDTO itemDTO);
    List<GroceryItemDTO> getAllGroceryItems();
    String removeGroceryItem(Long itemId);
    String updateGroceryItem(GroceryItemDTO itemDTO);
    String manageInventory(Long itemId, int quantity);
}
