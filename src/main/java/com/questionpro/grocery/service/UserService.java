package com.questionpro.grocery.service;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.dto.GroceryOrderDTO;

import java.util.List;

public interface UserService {
    List<GroceryItemDTO> getAllAvailableGroceryItems();
    String createOrder(List<GroceryOrderDTO> items);
}