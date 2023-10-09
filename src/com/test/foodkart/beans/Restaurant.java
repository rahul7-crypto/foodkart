package com.test.foodkart.beans;


import java.util.UUID;

public class Restaurant {
    private String id;
    private String name;
    private String ownerId;
    private String pinCode;
    private long createdAt;
    private long updateAt;


    public Restaurant(String name, String ownerId, String pinCode) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ownerId = ownerId;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
