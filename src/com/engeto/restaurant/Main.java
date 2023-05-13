package com.engeto.restaurant;

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

    System.out.println("We have " + dishList.dishListSize() + " dishes on the list in total for now. The current dish list is:");
    dishList.printDishList();


    MenuList menu = new MenuList();
        menu.addDishToMenu(dishList.dishList.get(0));
        menu.addDishToMenu(dishList.dishList.get(1));
        menu.addDishToMenu(dishList.dishList.get(2));
        menu.addDishToMenu(dishList.dishList.get(3));
        menu.addDishToMenu(dishList.dishList.get(7));
        menu.addDishToMenu(dishList.dishList.get(8));

        System.out.println("*******************************");
        System.out.println("We have " + menu.menuSize() + " dishes on the menu for now. The current menu is:");
        menu.printMenu();




    }
}