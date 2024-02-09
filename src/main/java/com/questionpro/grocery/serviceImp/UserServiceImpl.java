package com.questionpro.grocery.serviceImp;

import com.questionpro.grocery.dto.GroceryItemDTO;
import com.questionpro.grocery.dto.GroceryOrderDTO;
import com.questionpro.grocery.entity.GroceryItem;
import com.questionpro.grocery.entity.GroceryOrder;
import com.questionpro.grocery.entity.OrderHistory;
import com.questionpro.grocery.repository.GroceryItemRepository;
import com.questionpro.grocery.repository.GroceryOrderRepository;
import com.questionpro.grocery.repository.OrderHistoryRepository;
import com.questionpro.grocery.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private GroceryOrderRepository groceryOrderRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<GroceryItemDTO> getAllAvailableGroceryItems() {
        List<GroceryItem> items = groceryItemRepository.findAll();
        return items.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createOrder(List<GroceryOrderDTO> items) {
        OrderHistory orderHistory = new OrderHistory();
        double totalAmount = 0.0;
        List<GroceryOrder> groceryOrders = new ArrayList<>();

        for (GroceryOrderDTO itemDTO : items) {
            GroceryItem item = groceryItemRepository.findById(itemDTO.getItemId()).orElse(null);
            if (item != null && item.getQuantity() >= itemDTO.getQuantity()) {
                totalAmount += item.getPrice() * itemDTO.getQuantity();
                item.setQuantity(item.getQuantity() - itemDTO.getQuantity());
                groceryOrders.add(new GroceryOrder(item, itemDTO.getQuantity(), orderHistory));
            } else {
                throw new IllegalArgumentException("Insufficient stock for item with ID: " + itemDTO.getItemId());
            }
        }

        orderHistory.setTotalAmount(totalAmount);
        orderHistoryRepository.save(orderHistory);
        groceryOrderRepository.saveAll(groceryOrders);
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