package com.test.foodkart.repositories;

import com.test.foodkart.beans.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantReviewRepository {
    private Map<String, List<Review>> restaurantRatingsMap;

    public RestaurantReviewRepository() {
        this.restaurantRatingsMap = new HashMap<>();
    }

    public Review save(Review review) {
        List<Review> existingRatings = restaurantRatingsMap.getOrDefault(review.getRestaurantId(), new ArrayList<>());
        review.setUpdateAt(System.currentTimeMillis());
        existingRatings.add(review);
        restaurantRatingsMap.put(review.getRestaurantId(), existingRatings);
        return review;
    }

    public void addRating(Review review) {
        List<Review> existingRatings = restaurantRatingsMap.getOrDefault(review.getRestaurantId(), new ArrayList<>());
        existingRatings.add(review);
        restaurantRatingsMap.put(review.getRestaurantId(), existingRatings);
    }

    public List<Review> findByRestaurantId(String restaurantId) {
        return restaurantRatingsMap.getOrDefault(restaurantId, new ArrayList<>());
    }
}
