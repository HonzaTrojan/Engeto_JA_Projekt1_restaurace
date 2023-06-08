package com.engeto.restaurant;

import java.math.BigDecimal;
import java.time.Duration;

public class Dish {
    private String title;
    private double price;

    /**
     * prepartionTime = time in minutes
     */
    private int preparationTime;
    String photoUrl = "blank";
    Category category = Category.MAINDISH;

    public Dish(String title, double price, int preparationTime, String photoUrl, Category category) {
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.photoUrl = photoUrl;
        this.category = category;
    }

    public Dish(String title, double price, int preparationTime, Category category){
        this(title, price, preparationTime, "blank", category);
    }


    ///region Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
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


    @Override
    public String toString() {
        return title;
    }
}
