package com.test.foodkart.services;

import com.test.foodkart.beans.User;
import com.test.foodkart.enums.Gender;

public interface IUserService {
    User registerUser(String name, Gender gender, String phoneNumber, String pinCode);
    void login(String userId);
    User findLoggedInUser();
}
