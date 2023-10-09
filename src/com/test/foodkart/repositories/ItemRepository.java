package com.test.foodkart.repositories;

import com.test.foodkart.beans.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {
    private Map<String, Item> restaurantItemMap;

    public ItemRepository() {
        this.restaurantItemMap = new HashMap<>();
    }

    public Item save(Item item) {
        item.setUpdateAt(System.currentTimeMillis());
        restaurantItemMap.put(item.getRestaurantId(), item);
        return item;
    }

    public Item findByRestaurantId(String restaurantId) {
        return restaurantItemMap.get(restaurantId);
    }
}
