package com.engeto.restaurant;

import java.math.BigDecimal;


public class Dish {
    private String title;
    private BigDecimal price;

    /**
     * prepartionTime = time in minutes
     */
    private int preparationTimeMinutes;
    String photoUrl = "blank";
    Category category = Category.MAINDISH;

    public Dish(String title, BigDecimal price, int preparationTimeMinutes, String photoUrl, Category category) {
        this.title = title;
        this.price = price;
        this.preparationTimeMinutes = preparationTimeMinutes;
        this.photoUrl = photoUrl;
        this.category = category;
    }

    public Dish(String title, BigDecimal price, int preparationTimeMinutes, Category category){
        this(title, price, preparationTimeMinutes, "blank", category);
    }


    ///region Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    public void setPreparationTimeMinutes(int preparationTimeMinutes) {
        this.preparationTimeMinutes = preparationTimeMinutes;
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

//    public String getCategoryLowerCase(){
//        if (getCategory().equals(Category.STARTER)) return "starter";
//        else if (getCategory().equals(Category.SOUP)) return "soup";
//        else if (getCategory().equals(Category.MAINDISH)) return "main dish";
//        else if (getCategory().equals(Category.DESSERT)) return "dessert";
//        else if (getCategory().equals(Category.DRINK)) return "drink";
//        return null;
//    }



    @Override
    public String toString() {
        return title;
    }
}
