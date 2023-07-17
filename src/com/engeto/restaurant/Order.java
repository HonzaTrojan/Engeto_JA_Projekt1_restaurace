package com.engeto.restaurant;

import java.time.LocalDateTime;
/**
 *   Order - overview of one particular order with details (e.g. name of waiter, number of table, list of dishes ordered etc.)
 */
public class Order {
    private int table;
    private String waiter;
    private Dish dish;
    private LocalDateTime orderedTime;
    private LocalDateTime fulfilmentTime;
    private boolean isTheOrderFulfilled;
    private String note;

    public Order(int table, String waiter, Dish dish, LocalDateTime orderedTime,
                 LocalDateTime fulfilmentTime, boolean isTheOrderFulfilled, String note) {
        this.table = table;
        this.waiter = waiter;
        this.dish = dish;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.isTheOrderFulfilled = isTheOrderFulfilled;
        this.note = note;
    }

    /** Constructor without setting fulfilmetTime (the order is not finished yet)
    *       fulfilmentTime = orderedTime and isTheOrderFulfilled = false
    */
    public Order (int table, String waiter, Dish dish, LocalDateTime orderedTime, String note) {
        this (table, waiter, dish, orderedTime, orderedTime, false, note);
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

    public Dish getDishFromOrder() {
        return dish;
    }

    public void setDishToOrder(Dish dish) {
        this.dish = dish;
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

    public boolean isTheOrderFulfilled() {
        return isTheOrderFulfilled;
    }

    public void setTheOrderFulfilled(boolean theOrderFulfilled) {
        isTheOrderFulfilled = theOrderFulfilled;
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
                "\n     Dish ordered: " + dish +
                "\n     Time of order: " + orderedTime +
                ", time of fulfilment: " + fulfilmentTime +
                "\n     Note: " + note;
    }
}
