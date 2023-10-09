package com.test.foodkart.services.impl;

import com.test.foodkart.beans.User;
import com.test.foodkart.enums.Gender;
import com.test.foodkart.repositories.UserRepository;
import com.test.foodkart.services.IUserService;

public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String name, Gender gender, String phoneNumber, String pinCode) {
        User user = new User(name, gender, phoneNumber, pinCode);
        return userRepository.save(user);
    }

    @Override
    public void login(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new RuntimeException("Invalid UserId!");
        }
        userRepository.login(userId);
    }

    @Override
    public User findLoggedInUser() {
        return userRepository.findLoggedInUser();
    }
}
