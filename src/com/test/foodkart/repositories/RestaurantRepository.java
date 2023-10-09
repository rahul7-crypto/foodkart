package com.test.foodkart.repositories;

import com.test.foodkart.beans.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantRepository {
    private Map<String, Restaurant> restaurantMap;

    public RestaurantRepository() {
        this.restaurantMap = new HashMap<>();
    }

    public Restaurant save(Restaurant restaurant) {
        restaurant.setUpdateAt(System.currentTimeMillis());
        restaurantMap.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    public Restaurant findById(String restaurantId) {
        return restaurantMap.get(restaurantId);
    }
}
