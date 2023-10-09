package com.test.foodkart.services;

import com.test.foodkart.beans.Item;

public interface IItemService {
    Item addItem(String name, double price, int initialQuantity, String restaurantId);
    void addQuantity(String restaurantId, int quantityToBeAdded);

    Item findByRestaurantId(String restaurantId);
}
