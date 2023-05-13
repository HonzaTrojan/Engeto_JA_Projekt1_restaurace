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
    public int dishListSize(){
        return dishList.size();
    }

    public void printDishList(){
        int i = 1;
        for (Dish dish : dishList){
            System.out.println("Dish no." + i + ": " + dish.getTitle() + ", price of dish is " + dish.getPrice() +
                    " Eur, preparation time is " + dish.getPreparationTime() + " minutes, category of dish is " +
                    dish.getCategory());
            i++;
        }
    }



}
