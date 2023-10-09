package com.test.foodkart.services.impl;

import com.test.foodkart.beans.Review;
import com.test.foodkart.beans.User;
import com.test.foodkart.repositories.RestaurantReviewRepository;
import com.test.foodkart.services.IRestaurantReviewService;
import com.test.foodkart.services.IUserService;

import java.util.List;

public class RestaurantReviewService implements IRestaurantReviewService {
    private RestaurantReviewRepository restaurantReviewRepository;
    private IUserService userService;

    public RestaurantReviewService(RestaurantReviewRepository restaurantReviewRepository, IUserService userService) {
        this.restaurantReviewRepository = restaurantReviewRepository;
        this.userService = userService;
    }

    @Override
    public Review rateRestaurant(String restaurantId, int rating, String comment) {
        User loggedInUser = userService.findLoggedInUser();
        if (loggedInUser == null) {
            throw new RuntimeException("Please login to add review!");
        }
        Review review = new Review(loggedInUser.getId(), comment, rating, restaurantId);
        return restaurantReviewRepository.save(review);
    }

    @Override
    public List<Review> findByRestaurantId(String restaurantId) {
        return restaurantReviewRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public double findAverageRating(String restaurantId) {
        List<Review> reviews = restaurantReviewRepository.findByRestaurantId(restaurantId);
        double totalRatings = 0.0;
        int total = 0;
        for (Review review : reviews) {
            if (review.getRating() > 0) {
                totalRatings += review.getRating();
                total++;
            }
        }
        return totalRatings / total;
    }
}
