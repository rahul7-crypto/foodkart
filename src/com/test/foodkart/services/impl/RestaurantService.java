package com.test.foodkart.services.impl;

import com.test.foodkart.beans.Item;
import com.test.foodkart.beans.Restaurant;
import com.test.foodkart.beans.User;
import com.test.foodkart.repositories.RestaurantRepository;
import com.test.foodkart.services.*;

import java.util.*;

public class RestaurantService implements IRestaurantService {

    private RestaurantRepository restaurantRepository;
    private IItemService iItemService;
    private IUserService userService;
    private IRestaurantServiceability restaurantServiceability;
    private IRestaurantReviewService restaurantReviewService;

    public RestaurantService(RestaurantRepository restaurantRepository, IItemService iItemService,
                             IUserService userService, IRestaurantServiceability restaurantServiceability,
                             IRestaurantReviewService restaurantReviewService) {
        this.restaurantRepository = restaurantRepository;
        this.iItemService = iItemService;
        this.userService = userService;
        this.restaurantServiceability = restaurantServiceability;
        this.restaurantReviewService = restaurantReviewService;
    }

    @Override
    public Restaurant registerRestaurant(String restaurantName, List<String> serviceablePinCodes, String itemName, double itemPrice, int initialQuantity) {
        User user = userService.findLoggedInUser();
        Restaurant restaurant = restaurantRepository.save(new Restaurant(restaurantName, user.getId(), user.getPinCode()));
        iItemService.addItem(itemName, itemPrice, initialQuantity, restaurant.getId());
        restaurantServiceability.addRestaurantToAreas(restaurant.getId(), serviceablePinCodes);
        return restaurant;
    }

    @Override
    public void updateQuantity(String restaurantId, int quantityToAdd) {
        User user = userService.findLoggedInUser();
        Restaurant restaurant = restaurantRepository.findById(restaurantId);
        if (!user.getId().equals(restaurant.getOwnerId())) {
            throw new RuntimeException("Only Restaurant Owner Can Add Items!");
        }
        iItemService.addQuantity(restaurantId, quantityToAdd);
    }

    @Override
    public List<Restaurant> showRestaurantsByRatings() {
        User user = userService.findLoggedInUser();
        Set<String> serviceableRestaurantIds = restaurantServiceability.findServiceableRestaurantsByPinCode(user.getPinCode());

        PriorityQueue<Map.Entry<String, Double>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (String restaurantId : serviceableRestaurantIds) {
            double rating = restaurantReviewService.findAverageRating(restaurantId);
            maxHeap.add(Map.entry(restaurantId, rating));
        }

        List<Restaurant> restaurants = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Double> entry = maxHeap.poll();
            restaurants.add(restaurantRepository.findById(entry.getKey()));
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> showRestaurantsByPrices() {
        User user = userService.findLoggedInUser();
        Set<String> serviceableRestaurantIds = restaurantServiceability.findServiceableRestaurantsByPinCode(user.getPinCode());

        PriorityQueue<Map.Entry<Item, Double>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (String restaurantId : serviceableRestaurantIds) {
            Item item = iItemService.findByRestaurantId(restaurantId);
            maxHeap.add(Map.entry(item, item.getPrice()));
        }

        List<Restaurant> restaurants = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Item, Double> entry = maxHeap.poll();
            restaurants.add(restaurantRepository.findById(entry.getKey().getRestaurantId()));
        }
        return restaurants;
    }
}
