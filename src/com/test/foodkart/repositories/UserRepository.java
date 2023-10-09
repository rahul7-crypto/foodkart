package com.test.foodkart.repositories;

import com.test.foodkart.beans.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap;
    private User loggedInUser;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    public User save(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        userMap.put(user.getId(), user);
        return user;
    }

    public void login(String userId) {
        loggedInUser = userMap.get(userId);
    }

    public User findLoggedInUser() {
        return loggedInUser;
    }

    public User findById(String userId) {
        return userMap.get(userId);
    }
}
