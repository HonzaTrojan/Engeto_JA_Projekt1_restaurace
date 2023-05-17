package com.engeto.restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Orders {
    private int table;
    private String waiter;
    private OrdersList ordersList;
    private LocalDateTime orderedTime;
    private LocalDateTime fulfilmentTime = null;
    private String note;

    public Orders(int table, String waiter, OrdersList ordersList, LocalDateTime orderedTime, LocalDateTime fulfilmentTime, String note) {
        this.table = table;
        this.waiter = waiter;
        this.ordersList = ordersList;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.note = note;
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

    public OrdersList getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(OrdersList ordersList) {
        this.ordersList = ordersList;
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
                "\n Dishes ordered: " + ordersList +
                "\n Time of order: " + orderedTime +
                ", time of fulfilment: " + fulfilmentTime +
                "\nNote: " + note;
    }
}
