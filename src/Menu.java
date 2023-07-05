import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
/**
 * Created by Charlton Howard of 7/5/2023
 * Menu class for Generating and running the menu
 */
public class Menu {
    private HashMap<Integer,MenuItem> menu = new HashMap<>();
    private int keyCount = 1;

    /**
     * Returns menu as a HashMap
     * @return menu
     */
    public HashMap getMenu(){
        return menu;
    }

    /**
     * Checks the time, returns whether it is morning. If store is closed, throws exception
     * @return true if morning and store is open
     * @throws StoreClosedException Store is closed
     */
    public boolean mornCheck() throws StoreClosedException {
        Date a = new Date();
        if((a.getHours() < 13) && (a.getHours() > 10)){
            return true;
        } else if(a.getHours()>= 13 && a.getHours() < 23){
            return false;
        } else{
            throw new StoreClosedException();
        }

    }

    /**
     * Runs private method fillMenu()
     */
    public void start(){
        fillMenu();
    }

    /**
     * Fills HashMap menu from internal file
     */
    private void fillMenu(){
        try{
            Scanner input = new Scanner(new File("src\\OutbackMenu.txt"));
            String type = "Drinks";
            String line;
            while(input.hasNext()){
                line = input.nextLine();
                String temp = line;
                switch (temp.toLowerCase()) {
                    case "drinks" -> type = "Drinks";
                    case "appetizers" -> type = "Appetizers";
                    case "entrees" -> type = "Entrees";
                    case "desserts" -> type = "Desserts";
                    default -> {
                        addItem(type, line);
                        keyCount++;
                    }
                }
            }

        }catch(FileNotFoundException E){
            System.out.println("No file found");
        }
    }


    /**
     * Inserts item that extends MenuItem into HashMap of the correct class
     * @param type type of class to insert
     * @param line line from file to evaluate
     */
    public void addItem(String type, String line){
        int temp;
        String name;
        String cost;
        switch (type) {
            case "Drinks" -> {
                temp = line.indexOf("$");
                name = line.substring(0, temp).trim();
                cost = line.substring(temp);
                menu.put(keyCount, new Drink(name, cost));
            }
            case "Appetizers" -> {
                temp = line.indexOf("$");
                name = line.substring(0, temp).trim();
                cost = line.substring(temp);
                menu.put(keyCount, new Appetizer(name, cost));
            }
            case "Entrees" -> {
                temp = line.indexOf("$");
                name = line.substring(0, temp).trim();
                cost = line.substring(temp);
                menu.put(keyCount, new Entree(name, cost));
            }
            case "Desserts" -> {
                temp = line.indexOf("$");
                name = line.substring(0, temp).trim();
                cost = line.substring(temp);
                menu.put(keyCount, new Dessert(name, cost));
            }
            default -> {
            }
        }

    }


}

/**
 * Custom Exception if Store is closed
 */
class StoreClosedException extends Exception {}