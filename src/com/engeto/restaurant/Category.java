package com.engeto.restaurant;

public enum Category {
    STARTER, SOUP, MAINDISH, DESSERT, DRINK;


    public String toLowerCase() {
        return this.name().toLowerCase();
    }

//    static Enum category;
//    public static String getCategoryLowerCase(){
//        if (category.equals(Category.STARTER)) return "starter";
//        else if (category.equals(Category.SOUP)) return "soup";
//        else if (category.equals(Category.MAINDISH)) return "main dish";
//        else if (category.equals(Category.DESSERT)) return "dessert";
//        else if (category.equals(Category.DRINK)) return "drink";
//        return null;
//    }




}
