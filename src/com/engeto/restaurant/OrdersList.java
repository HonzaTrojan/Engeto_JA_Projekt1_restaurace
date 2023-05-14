package com.engeto.restaurant;

import java.util.ArrayList;
import java.util.List;

public class OrdersList {
    List<Dish> dishOrder = new ArrayList<>();

    public void addDishToOrder(Dish dish){
        dishOrder.add(dish);
    }

    public void removeDishFromOrder(Dish dish){
        dishOrder.remove(dish);
    }

    public void clearOrder(){
        dishOrder.clear();
    }


    @Override
    public String toString() {
        String result = "";
        for (Dish dish : dishOrder){
            result += dish.getTitle() + ", ";

        }

        return result;
    }
}
