package com.engeto.restaurant;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

    Dish dish1 = new Dish("Spegetti carbonara", 10.50, 20, "SpegettiCarb01, SpagettiCarb02", Category.MAINDISH);
    Dish dish2 = new Dish("Gazpacho", 15, 10, Category.SOUP);
    Dish dish3 = new Dish("Tiramisu", 6.50, 5, "Tiram.photo", Category.DESSERT);
    Dish dish4 = new Dish("Wiener schnitzel", 25, 25, "Wiener01", Category.MAINDISH);
    Dish dish5 = new Dish("Rakvička", 3.89, 2, Category.DESSERT);
    Dish dish6 = new Dish("Cabbage soup", 7.50, 7, Category.SOUP);
    Dish dish7 = new Dish("Octopus with sweet potato", 17.99, 18, "Octopus-09", Category.MAINDISH);
    Dish dish8 = new Dish("Steak, fries, coleslaw", 35, 23, "Spegetti01, Spagetti02", Category.MAINDISH);
    Dish dish9 = new Dish("Carpaccio", 6.39, 8, "Carpacio-pic1", Category.STARTER);
    Dish dish10 = new Dish("Tlačenka s cibulí", 5.35, 6, "Tlaca05", Category.STARTER);
    Dish dish11 = new Dish("Mojito", 7.35, 5, "Mojito01", Category.DRINK);
    Dish dish12 = new Dish("Pivo", 4.25, 4, "Plzen-pic, hladinka01", Category.DRINK);


    DishList dishList = new DishList();
        dishList.addDish(dish1);
        dishList.addDish(dish2);
        dishList.addDish(dish3);
        dishList.addDish(dish4);
        dishList.addDish(dish5);
        dishList.addDish(dish6);
        dishList.addDish(dish7);
        dishList.addDish(dish8);
        dishList.addDish(dish9);
        dishList.addDish(dish10);
        dishList.addDish(dish11);
        dishList.addDish(dish12);

    System.out.println("We have " + dishList.dishListSize() + " dishes and drinks on the list in total for now. The current dish list is:");
    dishList.printDishList();


    MenuList menu = new MenuList();
        menu.addDishToMenu(dishList.dishList.get(0));
        menu.addDishToMenu(dishList.dishList.get(1));
        menu.addDishToMenu(dishList.dishList.get(2));
        menu.addDishToMenu(dishList.dishList.get(3));
        menu.addDishToMenu(dishList.dishList.get(7));
        menu.addDishToMenu(dishList.dishList.get(8));
        menu.addDishToMenu(dishList.dishList.get(11));

        System.out.println("*******************************");
        System.out.println("We have " + menu.menuSize() + " dishes and drinks on the menu for now. The current menu is:");
        menu.printMenu();



        OrdersList ordersList1 = new OrdersList();
        ordersList1.addDishToOrder(menu.getDishFromMenu(0));
        ordersList1.addDishToOrder(menu.menu.get(1));
        ordersList1.addDishToOrder(menu.menu.get(2));
        ordersList1.addDishToOrder(menu.menu.get(6));

        Orders order1 = new Orders(1, "Franta", ordersList1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), "Dish and service were amazing!");

        System.out.println("*******************************");
        System.out.println(order1);

        OrdersList ordersList2 = new OrdersList();
        ordersList2.addDishToOrder(menu.getDishFromMenu(3));
        ordersList2.addDishToOrder(menu.menu.get(5));


        Orders order2 = new Orders(3, "Jana", ordersList2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(45), "I like the dinner but service was sooo slow!");

        System.out.println("*******************************");
        System.out.println(order2);


        // dishList, menu, ordersList1, ordersList2

//        try {
//            dishList.loadDataFromDishAndMenuFile(Settings.getDishListFilename());
//        } catch (DishException e) {
//            System.err.println(e.getLocalizedMessage());
//
//        System.out.println(dishList.getList());

//        dishList.addDataIntoDishAndMenuFile("dishList.txt");

        try {
            dishList.addDataIntoDishAndMenuFile(Settings.getDishListFilename());
        } catch (DishException ex) {
            System.err.println(ex.getLocalizedMessage());
        }



    }
}
