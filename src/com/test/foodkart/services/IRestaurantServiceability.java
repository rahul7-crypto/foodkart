package com.test.foodkart.services;

import java.util.List;
import java.util.Set;

public interface IRestaurantServiceability {
    void addRestaurantToArea(String restaurantId, String pinCode);
    void addRestaurantToAreas(String restaurantId, List<String> pinCodes);
    Set<String> findServiceableRestaurantsByPinCode(String pinCode);
}
