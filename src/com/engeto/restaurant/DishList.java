package com.engeto.restaurant;

import java.util.ArrayList;
import java.util.List;

public class DishList {

    List<Dish> dishList = new ArrayList<>();

    public void addDish(Dish dish){
        dishList.add(dish);
    }

    public void removeDish(Dish dish){
        dishList.remove(dish);
    }



}
