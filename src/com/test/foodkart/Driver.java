package com.test.foodkart;

import com.test.foodkart.beans.Restaurant;
import com.test.foodkart.beans.User;
import com.test.foodkart.enums.Gender;
import com.test.foodkart.repositories.*;
import com.test.foodkart.services.*;
import com.test.foodkart.services.impl.*;

import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        IUserService userService = new UserService(userRepository);

        User userA = userService.registerUser("userA", Gender.M, "88888888", "560037");
        User userB = userService.registerUser("userB", Gender.M, "88888899", "560025");

        userService.login(userA.getId());
        userService.login(userB.getId());
        User loggedInUser = userService.findLoggedInUser();
        System.out.println(userB.equals(loggedInUser));

        RestaurantReviewRepository restaurantReviewRepository = new RestaurantReviewRepository();
        IRestaurantReviewService restaurantReviewService = new RestaurantReviewService(restaurantReviewRepository, userService);

        RestaurantServiceabilityRepository restaurantServiceabilityRepository = new RestaurantServiceabilityRepository();
        IRestaurantServiceability restaurantServiceability = new RestaurantServiceability(restaurantServiceabilityRepository);

        ItemRepository itemRepository = new ItemRepository();
        IItemService iItemService = new ItemService(itemRepository);

        RestaurantRepository restaurantRepository = new RestaurantRepository();
        IRestaurantService restaurantService = new RestaurantService(restaurantRepository, iItemService, userService, restaurantServiceability, restaurantReviewService);

        Restaurant restaurant = restaurantService.registerRestaurant("Meghana Biryani", Arrays.asList("560037", "560025", "560064"), "Chicken Biryani",
                320.50, 100);
        restaurantService.updateQuantity(restaurant.getId(), 5);

        restaurantReviewService.rateRestaurant(restaurant.getId(), 3, "Not Bad");

    }
}
