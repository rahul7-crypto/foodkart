package com.test.foodkart.services;

import com.test.foodkart.beans.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant registerRestaurant(String restaurantName, List<String> serviceablePinCodes, String itemName, double itemPrice, int initialQuantity);

    void updateQuantity(String restaurantId, int quantityToAdd);
    List<Restaurant> showRestaurantsByRatings();
    List<Restaurant> showRestaurantsByPrices();
}
