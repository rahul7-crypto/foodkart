package com.test.foodkart.repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestaurantServiceabilityRepository {

    // Map Of Pin code to set of restaurant Ids
    private Map<String, Set<String>> areaToRestaurantsMap;

    public RestaurantServiceabilityRepository() {
        this.areaToRestaurantsMap = new HashMap<>();
    }

    public void addRestaurant(String restaurantId, String pinCode) {
        Set<String> existingRestaurants = areaToRestaurantsMap.getOrDefault(pinCode, new HashSet<>());
        if (existingRestaurants.contains(restaurantId)) {
            return;
        }
        existingRestaurants.add(restaurantId);
        areaToRestaurantsMap.put(pinCode, existingRestaurants);
    }

    public Set<String> findServiceableRestaurantsByPinCode(String pinCode) {
        return areaToRestaurantsMap.getOrDefault(pinCode, new HashSet<>());
    }

}
