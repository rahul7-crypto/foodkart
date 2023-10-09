package com.test.foodkart.repositories;

import com.test.foodkart.beans.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private Map<String, List<Order>> userOrders;

    public OrderRepository() {
        this.userOrders = new HashMap<>();
    }

    public Order save(Order order) {
        List<Order> existingOrders = userOrders.getOrDefault(order.getUserId(), new ArrayList<>());
        order.setUpdatedAt(System.currentTimeMillis());
        existingOrders.add(order);
        userOrders.put(order.getUserId(), existingOrders);
        return order;
    }

    public List<Order> findByUserId(String userId) {
        return userOrders.getOrDefault(userId, new ArrayList<>());
    }

}
