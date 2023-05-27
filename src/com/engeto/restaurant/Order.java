package com.engeto.restaurant;

import java.time.LocalDateTime;
/**
 *   Order - overview of one particular order with details (e.g. name of waiter, number of table, list of dishes ordered etc.)
 */
public class Order {
    private int table;
    private String waiter;
    private OrderOfDish orderOfDishList;
    private LocalDateTime orderedTime;
    private LocalDateTime fulfilmentTime = null;
    private String note;

    public Order(int table, String waiter, OrderOfDish orderOfDishList, LocalDateTime orderedTime, LocalDateTime fulfilmentTime, String note) {
        this.table = table;
        this.waiter = waiter;
        this.orderOfDishList = orderOfDishList;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.note = note;
    }

    public Order (int table, String waiter, OrderOfDish orderOfDishList, LocalDateTime orderedTime, String note) {
        this (table, waiter, orderOfDishList, orderedTime, null, note);
    }

    ///region Getters and setters

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public OrderOfDish getOrdersList() {
        return orderOfDishList;
    }

    public void setOrdersList(OrderOfDish orderOfDishList) {
        this.orderOfDishList = orderOfDishList;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public LocalDateTime getFulfilmentTime() {
        return fulfilmentTime;
    }

    public void setFulfilmentTime(LocalDateTime fulfilmentTime) {
        this.fulfilmentTime = fulfilmentTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    ///endregion





    @Override
    public String toString() {
        return "Order on table no." + table +
                ", waiter name is " + waiter +
                "\n Dishes ordered: " + orderOfDishList +
                "\n Time of order: " + orderedTime +
                ", time of fulfilment: " + fulfilmentTime +
                "\nNote: " + note;
    }
}
