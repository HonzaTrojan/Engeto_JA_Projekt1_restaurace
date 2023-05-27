package com.engeto.restaurant;
/**
 *   OrderOfDish - list of dishes ordered in one particular order
 */
import java.util.ArrayList;
import java.util.List;

public class OrderOfDish {
    List<Dish> order = new ArrayList<>();

    public void addDishToOrder(Dish dish){
        order.add(dish);
    }

    public void removeDishFromOrder(Dish dish){
        order.remove(dish);
    }

    public void clearOrder(){
        order.clear();
    }


//    public Orders fromStringToOrders(String text){
//        Order order = new Order()
//
//        return order;
//    }


//    line = dish.getTitle() + Settings.DELIMITER + dish.getPrice() + Settings.DELIMITER +
//            dish.getPreparationTime() + Settings.DELIMITER + dish.getPhotoUrl() +
//    Settings.DELIMITER + dish.getCategory();

    @Override
    public String toString() {
        String result = "";
        for (Dish dish : order){
            result += dish.getTitle() + ", ";

        }

        return result;
    }
}
