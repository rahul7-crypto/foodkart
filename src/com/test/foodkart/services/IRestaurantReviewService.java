package com.test.foodkart.services;

import com.test.foodkart.beans.Review;

import java.util.List;

public interface IRestaurantReviewService {
    Review rateRestaurant(String restaurantId, int rating, String comment);
    List<Review> findByRestaurantId(String restaurantId);

    double findAverageRating(String restaurantId);
}
