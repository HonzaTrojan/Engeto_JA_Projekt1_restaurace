// Discord - Honza T.#3841

package com.engeto.restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        Dish dish1 = new Dish("Spegetti carbonara", BigDecimal.valueOf(10.50), 20, "SpegettiCarb01, SpagettiCarb02", Category.MAINDISH);
        Dish dish2 = new Dish("Gazpacho", BigDecimal.valueOf(15), 10, Category.SOUP);
        Dish dish3 = new Dish("Tiramisu", BigDecimal.valueOf(6.50), 5, "Tiram.photo", Category.DESSERT);
        Dish dish4 = new Dish("Wiener schnitzel", BigDecimal.valueOf(25), 25, "Wiener01", Category.MAINDISH);
        Dish dish5 = new Dish("Rakvička", BigDecimal.valueOf(3.89), 2, Category.DESSERT);
        Dish dish6 = new Dish("Cabbage soup", BigDecimal.valueOf(7.50), 7, Category.SOUP);
        Dish dish7 = new Dish("Octopus with sweet potato", BigDecimal.valueOf(17.99), 18, "Octopus-09", Category.MAINDISH);
        Dish dish8 = new Dish("Steak, fries, coleslaw", BigDecimal.valueOf(35), 23, "Spegetti01, Spagetti02", Category.MAINDISH);
        Dish dish9 = new Dish("Carpaccio", BigDecimal.valueOf(6.39), 8, "Carpacio-pic1", Category.STARTER);
        Dish dish10 = new Dish("Tlačenka s cibulí", BigDecimal.valueOf(5.35), 6, "Tlaca05", Category.STARTER);
        Dish dish11 = new Dish("Mojito", BigDecimal.valueOf(7.35), 5, "Mojito01", Category.DRINK);
        Dish dish12 = new Dish("Pivo", BigDecimal.valueOf(4.25), 4, "Plzen-pic, hladinka01", Category.DRINK);

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

        try {
            dishList.addDataIntoDishFile(Settings.getDishListFilename());
        } catch (DishException ex) {
            System.err.println(ex.getLocalizedMessage());
        }

        dishList.clearDishList();

        try {
            dishList.loadDataFromDishFile(Settings.getDishListFilename());
        } catch (DishException e) {
            System.err.println(e.getLocalizedMessage());
            System.out.println(dishList.getList());
        }


        MenuList menu = new MenuList();
        menu.addDishToMenu(dishList.getDish(0));
        menu.addDishToMenu(dishList.getDish(1));
        menu.addDishToMenu(dishList.getDish(2));
        menu.addDishToMenu(dishList.getDish(3));
        menu.addDishToMenu(dishList.getDish(7));
        menu.addDishToMenu(dishList.getDish(8));
        menu.addDishToMenu(dishList.getDish(11));



        System.out.println("*******************************");
        System.out.println("We have " + menu.menuSize() + " dishes and drinks on the menu for now. The current menu is:");
        menu.printMenu();

        try {
            menu.addDataIntoMenuFile(Settings.getMenuFilename());
        } catch (DishException ex) {
            System.err.println(ex.getLocalizedMessage());
        }

        menu.clearMenuList();

        try {
            menu.loadDataFromMenuFile(Settings.getMenuFilename());
        } catch (DishException e) {
            System.err.println(e.getLocalizedMessage());
            System.out.println(menu.getMenu());
        }


        Order order1 = new Order(1, "Evelina", menu.getDishFromMenu(0), LocalDateTime.now().minusMinutes(120), LocalDateTime.now().minusMinutes(10), true, "Dish and service were amazing!");
        Order order2 = new Order(1, "Evelina", menu.getDishFromMenu(1), LocalDateTime.now().minusMinutes(120), LocalDateTime.now().minusMinutes(10), true, "Dish and service were amazing!");
        Order order3 = new Order(1, "Niel", menu.getDishFromMenu(2), LocalDateTime.now().minusMinutes(120), LocalDateTime.now().minusMinutes(10), true, "Dish and service were amazing!");
        Order order4 = new Order(1, "Evelina", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(120), LocalDateTime.now().minusMinutes(10), true, "Dish and service were amazing!");
        Order order5 = new Order(2, "Chrudo", menu.getDishFromMenu(3), LocalDateTime.now().minusMinutes(60), LocalDateTime.now().minusMinutes(5), true, "I like the food but service was sooo slow!");
        Order order6 = new Order(2, "Chrudo", menu.getDishFromMenu(5), LocalDateTime.now().minusMinutes(60), LocalDateTime.now().minusMinutes(5), true, "I like the food but service was sooo slow!");
        Order order7 = new Order(15, "Zed", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(120), "One more");
        Order order8 = new Order(15, "Stahlav", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(100), "One more....");
        Order order9 = new Order(15, "Stahlav", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(90), "One more....");
        Order order10 = new Order(15, "Alois", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(70), "One more....");
        Order order11 = new Order(15, "Stahlav", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(50), "One more....");
        Order order12 = new Order(15, "Stahlav", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(30), "One more....");
        Order order13 = new Order(15, "Stahlav", menu.getDishFromMenu(6), LocalDateTime.now().minusMinutes(10), "Aargh....");


        System.out.println("*******************************");
        System.out.println(order1 + "\n" + order2 + "\n" + order3 + "\n" + order4 + "\n" + order5 +
                "\n" + order6 + "\n" + order7 + "\n" + order8 + "\n" + order9 + "\n" + order10 +
                "\n" + order11 + "\n" + order12 + "\n" + order13);



        OrdersList ordersList = new OrdersList();
        ordersList.addOrderToOrdersList(order1);
        ordersList.addOrderToOrdersList(order2);
        ordersList.addOrderToOrdersList(order3);
        ordersList.addOrderToOrdersList(order4);
        ordersList.addOrderToOrdersList(order5);
        ordersList.addOrderToOrdersList(order6);
        ordersList.addOrderToOrdersList(order7);
        ordersList.addOrderToOrdersList(order8);
        ordersList.addOrderToOrdersList(order9);
        ordersList.addOrderToOrdersList(order10);
        ordersList.addOrderToOrdersList(order11);
        ordersList.addOrderToOrdersList(order12);
        ordersList.addOrderToOrdersList(order13);

        ordersList.getOrdersList();

        try {
            ordersList.addDataIntoOrdersFile(Settings.getOrdersFilename());
        } catch (DishException ex) {
            System.err.println(ex.getLocalizedMessage());
            System.out.println(ordersList.getOrdersList());
        }

        /**
         *   Test of right writting data from file
         */
        //ordersList.clearOrdersList();

        try {
            ordersList.loadDataFromOrdersFile(Settings.getOrdersFilename());
        } catch (DishException e) {
            System.err.println(e.getLocalizedMessage());
            System.out.println(ordersList.getOrdersList());
        }


        System.out.println("*******************************");
        System.out.println("Number of unfinished orders is: " + ordersList.numberOfUnfinishedOrders());

        System.out.println("List of unfinished orders: ");
        ordersList.listOfUnfinishedOrders();


        ordersList.sortOrdersByWaiter();
        System.out.println("*******************************");
        System.out.println("Orders sort by name of waiter: ");
        System.out.println(ordersList);

        ordersList.sortOrdersByOrderTime();
        System.out.println("*******************************");
        System.out.println("Orders sort by name of time of order: ");
        System.out.println(ordersList);

        System.out.println("*******************************");
        System.out.println("Total price of orders by waiters: ");
        ordersList.priceOfOrdersByWaiter();

        System.out.println("*******************************");
        System.out.println("Avg time to finish the order (in minutes): ");
        System.out.println(ordersList.avgTimeOfOrders(LocalDateTime.now().minusMinutes(300), LocalDateTime.now()));

        System.out.println("*******************************");
        System.out.println("Dishes ordered today: ");
        ordersList.dishesOrderedToday();

        System.out.println("*******************************");
        ordersList.exportForOneTable(1);






    }
}
