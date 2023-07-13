package com.engeto.restaurant;

public class Settings {
    public static final String ORDERS_FILENAME = "orders.txt";
    public static final String DISHLIST_FILENAME = "dishList.txt";
    public static final String MENU_FILENAME = "menu.txt";
    public static final String DELIMITER = "\t";


    public static String getOrdersFilename(){return ORDERS_FILENAME;}
    public static String getDishListFilename(){return DISHLIST_FILENAME;}
    public static String getMenuFilename(){return MENU_FILENAME;}
    public static String getDelimiter(){return DELIMITER;}




}

