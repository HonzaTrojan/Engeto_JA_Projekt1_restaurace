package com.engeto.restaurant;

import java.math.BigDecimal;
import java.time.Duration;

public class Dish {
    private String title;
    private int price;
    private Duration preparationTime;
    String photoUrl = "blank";
    Category category = Category.MAINDISH;

    public Dish(String title, int price, Duration preparationTime, String photoUrl, Category category) {
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.photoUrl = photoUrl;
        this.category = category;
    }


    ///region Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    ///endregion






}
