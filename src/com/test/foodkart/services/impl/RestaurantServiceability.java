package com.test.foodkart.services.impl;

import com.test.foodkart.repositories.RestaurantServiceabilityRepository;
import com.test.foodkart.services.IRestaurantServiceability;

import java.util.List;
import java.util.Set;

public class RestaurantServiceability implements IRestaurantServiceability {

    private RestaurantServiceabilityRepository restaurantServiceabilityRepository;
    public RestaurantServiceability(RestaurantServiceabilityRepository restaurantServiceabilityRepository) {
        this.restaurantServiceabilityRepository = restaurantServiceabilityRepository;
    }

    @Override
    public void addRestaurantToArea(String restaurantId, String pinCode) {
        restaurantServiceabilityRepository.addRestaurant(restaurantId, pinCode);
    }

    @Override
    public void addRestaurantToAreas(String restaurantId, List<String> pinCodes) {
        for (String pinCode : pinCodes) {
            restaurantServiceabilityRepository.addRestaurant(restaurantId, pinCode);
        }
    }

    @Override
    public Set<String> findServiceableRestaurantsByPinCode(String pinCode) {
        return restaurantServiceabilityRepository.findServiceableRestaurantsByPinCode(pinCode);
    }
}
