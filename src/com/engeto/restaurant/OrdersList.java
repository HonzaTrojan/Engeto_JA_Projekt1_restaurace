package com.engeto.restaurant;
/**
 *   OrdersList - overview of all ordered orders
 */
import java.io.*;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class OrdersList {

    List<Order> ordersList = new ArrayList<>();

    public List<Order> getOrdersList () {
        return new ArrayList<>(ordersList);
    }

    public void addOrderToOrdersList(Order order){
        ordersList.add(order);
    }

    public void removeOrderFromOrdersList(Order order){
        ordersList.remove(order);
    }

    public void clearOrdersList(){
        ordersList.clear();
    }

    public int ordersListSize (){
        return ordersList.size();
    }

    public Dish getDishFromOrderList (String nameOfDish){
        Dish dish = null;
        for (Order order : ordersList){
            if (order.getDishFromOrder().getTitle().equals(nameOfDish)) return order.getDishFromOrder();
        }
     return dish;
    }


    public int numberOfUnfinishedOrders(){
        int counter = 0;
        for (Order order : ordersList){
            if (order.getFulfilmentTime() == null) counter++;
        }
        return counter;
    }


    public void listOfUnfinishedOrders(){
        for (Order order : ordersList){
            if (order.getFulfilmentTime() == null) System.out.println("Table no.: " + order.getTable() +
                ", ordered food: " + order.getDishFromOrder() + ", time of order: " + order.getOrderedTime());
        }
    }


    public void priceOfOrdersByWaiter(){
        Set<String> setOfWaiters = new HashSet<>();
        for (Order order : ordersList){
            setOfWaiters.add(order.getWaiter());
        }
        List<String> listOfWaiters = new ArrayList<>(setOfWaiters);

        int numberOfWaiters = setOfWaiters.size();
        System.out.println("__________________");
        System.out.println(listOfWaiters);

        for (int i = 0; i < numberOfWaiters; i++){
            String waiterName = listOfWaiters.get(i);
            BigDecimal result = BigDecimal.valueOf(0);
            for (Order order : ordersList) {
                if (order.getWaiter() == waiterName){
                    result = result.add(order.getDishFromOrder().getPrice());
                }
        }
            System.out.println("Total price of orders of waiter " + waiterName + " is: " + result );
        }

    }


    public void sortOrdersByWaiter (){
        Collections.sort(ordersList, (o1, o2) -> o1.getWaiter().compareTo(o2.getWaiter()));
    }


    public void sortOrdersByOrderTime (){
        Collections.sort(ordersList, (o1, o2) -> o1.getOrderedTime().compareTo(o2.getOrderedTime()));
    }


    public double avgTimeOfOrders(LocalDateTime beginingOfPeriod, LocalDateTime endOfPeriod){
        Duration duration = Duration.ZERO;
        double result = 0;
        int numberOfOrders = 0;
        for (Order order : ordersList) {
            if (order.getFulfilmentTime() != null && order.getOrderedTime().isAfter(beginingOfPeriod) && order.getFulfilmentTime().isBefore(endOfPeriod)){
                duration = duration.plus(Duration.between(order.getOrderedTime(), order.getFulfilmentTime()));
                numberOfOrders++;
            }
        }
        result = duration.toMinutes()/numberOfOrders;
        return result;
    }

    public void dishesOrderedToday (){
        Set<String> dishesToday = new HashSet<>();
        for (Order order : ordersList) {
            dishesToday.add(order.getDishFromOrder().getTitle());
        }
        System.out.println(dishesToday);
    }

    public void exportForOneTable (int table){
        if (table<10) System.out.println("** Orders for table no.: " + " " + table + " **" + "\n****");
        else System.out.println("** Orders for table no.: " + table + " **" + "\n****");

        int counter = 1;
        for (Order order : ordersList) {
            if (order.getTable() == table){
                System.out.println(counter + ". " + order.getDishFromOrder() + " 1x (" +
                        order.getDishFromOrder().getPrice() + " Eur):\t" + order.getOrderedTime().getHour() +
                        ":" + order.getOrderedTime().getMinute() + "-" + order.getFulfilmentTime().getHour() +
                        ":" + order.getFulfilmentTime().getMinute() + "\t" + ", waiter: " + order.getWaiter());
                counter++;
            }
        }
        System.out.println("******");
    }



    public void addDataIntoOrdersFile(String filename) throws DishException {
        String line = "";

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Order order : ordersList){
                line = order.getTable() + Settings.DELIMITER + order.getWaiter() + Settings.DELIMITER +
                        order.getDishFromOrder() + Settings.DELIMITER + order.getOrderedTime() +
                        Settings.DELIMITER + order.getFulfilmentTime() + Settings.DELIMITER +
                        order.getNote();
                outputWriter.println(line);
            }
        } catch (IOException e) {
            System.err.println("IOException problem");
        }
    }




    public void loadDataFromOrdersFile(String filename) throws DishException {
        int lineNumber = 0;
        String[] items;
        String line = "";

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                items = line.split(Settings.DELIMITER);
              Order order = new Order(Integer.parseInt(items[0]), items[1], getDishFromOrderList(items[2]),
                        LocalDateTime.parse(items[3]), LocalDateTime.parse(items[4]), items[5]);
                ordersList.add(order);


            }
        } catch (FileNotFoundException e) {
            throw new DishException("File not found! File \"" +
                    filename + "\" is not available. " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new DishException("Wrong number format on line no." +
                    lineNumber + "\n Line: " + line + "\n\"" + e.getLocalizedMessage() + "\"");
        } catch (DateTimeException e) {
            throw new DishException("Wrong date format on line no." +
                    lineNumber + "\n Line: " + line + "\n\"" + e.getLocalizedMessage() + "\"");
        }
    }


    @Override
    public String toString() {
        String result = "";
        for (Order order : ordersList){
            result += order;

        }
        return result;
    }



}
