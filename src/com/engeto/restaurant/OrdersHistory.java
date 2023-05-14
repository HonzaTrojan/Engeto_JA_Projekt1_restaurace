package com.engeto.restaurant;

import java.util.ArrayList;
import java.util.List;

public class OrdersHistory {
    List<Orders> orderHistory = new ArrayList<>();

    public void addOrderToOrderHistory (Orders order){
        orderHistory.add(order);
    }
    public void removeOrderFromOrderHistory (Orders order){
        orderHistory.remove(order);
    }

}
