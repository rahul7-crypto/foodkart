package com.test.foodkart.beans;

import java.util.UUID;

public class Review {
    private String id;
    private String userId;
    private String comment;
    private int rating;
    private String restaurantId;
    private long createdAt;
    private long updateAt;

    public Review(String userId, String comment, int rating, String restaurantId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.restaurantId = restaurantId;
        this.createdAt = System.currentTimeMillis();
        this.updateAt = this.createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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
