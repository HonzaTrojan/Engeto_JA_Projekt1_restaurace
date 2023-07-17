package com.engeto.restaurant;
/**
 *   MenuList - dishes chosen from DishList for today`s offer
 */
import java.io.*;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuList {
    List<Dish> menu = new ArrayList<>();

    public List<Dish> getMenu () {
        return new ArrayList<>(menu);
    }

    public void addDishToMenu(Dish dish){
        menu.add(dish);
    }

    public void removeDishFromMenu(Dish dish){
        menu.remove(dish);
    }

    public void clearMenuList(){
        menu.clear();
    }

    public int menuSize(){
        return menu.size();
    }

    public Dish getDishFromMenu(int index){
        return menu.get(index);
    }

    public void printMenu(){
        int i = 1;
        for (Dish dish : menu){
            System.out.println("Dish no." + i + ": " + dish.getTitle() + ", price of dish is " + dish.getPrice() +
                    " Eur, preparation time is " + dish.getPreparationTimeMinutes() + " minutes, category of dish is \"" +
                    dish.getCategory().toLowerCase() + "\"");
            i++;
        }
    }

    public boolean isDishOnMenu(Dish dish){
        for (Dish dish1 : menu){
            if (dish1 == dish) return true;
        }
        return false;
    }


    public void addDataIntoMenuFile(String filename) throws DishException {
        String line = "";

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Dish dish : menu){
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



    public void loadDataFromMenuFile(String filename) throws DishException {
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
                menu.add(dish);
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
