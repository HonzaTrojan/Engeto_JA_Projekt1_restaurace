package com.engeto.restaurant;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    List<Dish> menu = new ArrayList<>();

    public void addDishToMenu(Dish dish){
        menu.add(dish);
    }

    public void removeDishFromMenu(Dish dish){
        menu.remove(dish);
    }

    public void removeAllFromMenu(){
        menu.clear();
    }


}
