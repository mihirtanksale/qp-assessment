package com.questionpro.grocery.serviceImp;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.entity.GroceryItem;
import com.questionpro.grocery.repository.GroceryItemRepository;
import com.questionpro.grocery.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public void addGroceryItem(GroceryItemDTO itemDTO) {
        GroceryItem item = new GroceryItem();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItemDTO> getAllGroceryItems() {
        List<GroceryItem> items = groceryItemRepository.findAll();
        return items.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    @Override
    public void updateGroceryItem(GroceryItemDTO itemDTO) {
        GroceryItem item = new GroceryItem();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        groceryItemRepository.save(item);
    }

    @Override
    @Transactional
    public void manageInventory(Long itemId, int quantity) {
        GroceryItem item = groceryItemRepository.findById(itemId).orElse(null);
        if (item != null) {
            item.setQuantity(quantity);
            groceryItemRepository.save(item);
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