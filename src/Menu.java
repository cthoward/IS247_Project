import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Menu {
    private HashMap<Integer,MenuItem> menu = new HashMap<>();
    int keyCount = 1;
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
    public void start(){
        fillMenu();
    }
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

    public HashMap getMenu(){
        return menu;
    }


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

class StoreClosedException extends Exception {}