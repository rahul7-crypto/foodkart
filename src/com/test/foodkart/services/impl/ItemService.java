package com.test.foodkart.services.impl;

import com.test.foodkart.beans.Item;
import com.test.foodkart.repositories.ItemRepository;
import com.test.foodkart.services.IItemService;

public class ItemService implements IItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(String name, double price, int initialQuantity, String restaurantId) {
        Item item = new Item(name, price, initialQuantity, restaurantId);
        return itemRepository.save(item);
    }

    @Override
    public void addQuantity(String restaurantId, int quantityToBeAdded) {
        Item item = itemRepository.findByRestaurantId(restaurantId);
        item.setInitialQuantity(item.getInitialQuantity() + quantityToBeAdded);
        itemRepository.save(item);
    }

    @Override
    public Item findByRestaurantId(String restaurantId) {
        return itemRepository.findByRestaurantId(restaurantId);
    }
}
