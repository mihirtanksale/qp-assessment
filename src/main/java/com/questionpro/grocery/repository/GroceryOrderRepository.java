package com.questionpro.grocery.repository;

import com.questionpro.grocery.entity.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryOrderRepository extends JpaRepository<GroceryOrder, Long> {

}