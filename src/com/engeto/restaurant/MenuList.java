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

    public int menuSize(){
        return menu.size();
    }

    public void printMenu(){
        int i = 1;
        for (Dish dish : menu){
            System.out.println("Dish no." + i + ": " + dish.getTitle() + ", price of dish is " + dish.getPrice() +
                    " Eur, preparation time is " + dish.getPreparationTime() + " minutes, category of dish is " +
                    dish.getCategory());
            i++;
        }
    }


}
