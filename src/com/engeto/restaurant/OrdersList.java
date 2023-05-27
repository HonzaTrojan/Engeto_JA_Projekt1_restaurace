package com.engeto.restaurant;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public int




    public void addDataIntoOrdersFile(String filename) throws DishException {
        String line = "";

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Order order : ordersList){
                line = order.getTable() + Settings.DELIMITER + order.getWaiter() + Settings.DELIMITER +
                        order.getOrdersList() + Settings.DELIMITER + order.getOrderedTime() +
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
//                Order order = new Order(Integer.parseInt(items[0]), items[1], Orders.class,       // na třetí pozici chybí items[2] = OrdersList ordersList
//                        LocalDateTime.parse(items[3]), LocalDateTime.parse(items[4]), items[5]);


//                ordersList.add(order);
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
