package com.questionpro.grocery.serviceImp;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.entity.GroceryItem;
import com.questionpro.grocery.entity.GroceryOrder;
import com.questionpro.grocery.repository.GroceryItemRepository;
import com.questionpro.grocery.repository.GroceryOrderRepository;
import com.questionpro.grocery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private GroceryOrderRepository groceryOrderRepository;

    @Override
    public String addGroceryItem(GroceryItemDTO itemDTO) {
        GroceryItem item = new GroceryItem();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        groceryItemRepository.save(item);
        return "Grocery item added successfully.";
    }

    @Override
    public List<GroceryItemDTO> getAllGroceryItems() {
        List<GroceryItem> items = groceryItemRepository.findAll();
        return items.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String removeGroceryItem(Long itemId) {
        // Check if there are any associated orders for the item
        List<GroceryOrder> associatedOrders = groceryOrderRepository.findByItemId(itemId);
        if (!associatedOrders.isEmpty()) {
            return "Cannot delete item. There are associated orders.";
        }

        // If no associated orders, proceed with item deletion
        groceryItemRepository.deleteById(itemId);
        return "Grocery item removed successfully.";
    }

    @Override
    public String updateGroceryItem(GroceryItemDTO itemDTO) {
        GroceryItem item = groceryItemRepository.findById(itemDTO.getId()).orElse(null);
        if (item != null) {
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setQuantity(itemDTO.getQuantity());
            groceryItemRepository.save(item);
            return "Grocery item updated successfully.";
        }else {
            return "Grocery item not found.";
        }

    }

    @Override
    public String manageInventory(Long itemId, int quantity) {
        GroceryItem item = groceryItemRepository.findById(itemId).orElse(null);
        if (item != null) {
            item.setQuantity(quantity);
            groceryItemRepository.save(item);
            return "Inventory managed successfully.";
        } else {
            return "Grocery item not found.";
        }
    }

    private GroceryItemDTO convertToDTO(GroceryItem item) {
        GroceryItemDTO itemDTO = new GroceryItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setQuantity(item.getQuantity());
        return itemDTO;
    }
}