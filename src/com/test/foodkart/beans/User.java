package com.test.foodkart.beans;

import com.test.foodkart.enums.Gender;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private Gender gender;
    private String phoneNumber;
    private String pinCode;
    private long createdAt;
    private long updateAt;

    public User(String name, Gender gender, String phoneNumber, String pinCode) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        this.createdAt = System.currentTimeMillis();
        this.updateAt = this.createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
