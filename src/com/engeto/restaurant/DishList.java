package com.engeto.restaurant;
/**
*   DishList - List of all possible dishes tha our cooks are able to cook (It is a base for creation of menu)
 */
import java.io.*;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishList {

    List<Dish> dishList = new ArrayList<>();

    public List<Dish> getList () {
        return new ArrayList<>(dishList);
    }

    public void addDish(Dish dish){
        dishList.add(dish);
    }
    public Dish getDish(int index){
        return dishList.get(index);
    }

    public void removeDish(Dish dish){
        dishList.remove(dish);
    }
    public int dishListSize(){
        return dishList.size();
    }
    public void clearDishList(){
        dishList.clear();
    }

    public void printDishList(){
        int i = 1;
        for (Dish dish : dishList){
            System.out.println("Dish no." + i + ": " + dish.getTitle() + ", price of dish is " + dish.getPrice() +
                    " Eur, preparation time is " + dish.getPreparationTimeMinutes() + " minutes, category of dish is \"" +
                    dish.getCategory().toLowerCase() + "\"");
            i++;
        }
    }






    public void addDataIntoDishFile(String filename) throws DishException {
        String line = "";

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Dish dish : dishList){
                line = dish.getTitle() + Settings.DELIMITER + dish.getPrice() + Settings.DELIMITER +
                        dish.getPreparationTimeMinutes() + Settings.DELIMITER + dish.getPhotoUrl() +
                        Settings.DELIMITER + dish.getCategory();
                outputWriter.println(line);
            }
        } catch (IOException e) {
            throw new DishException("Došlo k chybě při zápisu do soubrou: " + filename +
                    ": " + e.getLocalizedMessage());
        }
    }



    public void loadDataFromDishFile(String filename) throws DishException {
        int lineNumber = 0;
        String[] items;
        String line = "";

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                items = line.split(Settings.DELIMITER);
                Dish dish = new Dish(items[0], BigDecimal.valueOf(Double.parseDouble(items[1])), Integer.parseInt(items[2]),
                        items[3], Enum.valueOf(Category.class, items[4]));
                dishList.add(dish);
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


}
