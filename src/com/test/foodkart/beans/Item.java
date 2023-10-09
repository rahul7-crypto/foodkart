package com.test.foodkart.beans;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private double price;
    private int initialQuantity;
    private String restaurantId;
    private long createdAt;
    private long updateAt;

    public Item(String name, double price, int initialQuantity, String restaurantId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.initialQuantity = initialQuantity;
        this.restaurantId = restaurantId;
        this.createdAt = System.currentTimeMillis();
        this.updateAt = this.createdAt;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
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
