package com.questionpro.grocery.controller;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.dto.GroceryOrderDTO;
import com.questionpro.grocery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/available-items")
    public List<GroceryItemDTO> getAllAvailableGroceryItems() {
        return userService.getAllAvailableGroceryItems();
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestBody List<GroceryOrderDTO> items) {
        return userService.createOrder(items);
    }
}
