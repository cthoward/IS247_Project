import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean morn;
        Menu a = new Menu();
        Receipt b = new Receipt();

        try{
            morn = a.mornCheck();
            if(morn) {
                System.out.println("Good Morning and Welcome to Outback Steakhouse!");
                System.out.println("-----------------------------------------------");
            } else{
                System.out.println("Good Evening and Welcome to Outback Steakhouse!");
                System.out.println("-----------------------------------------------");
            }
        } catch (StoreClosedException e){
            System.out.println("Sorry! The store is currently closed.");
            System.exit(-1);
        }
        a.start();
        b = showMenu(a.getMenu());
        b.printBill();


    }
    public static Receipt showMenu(HashMap map){
        Receipt bill = new Receipt();
        boolean end = false;

        while(!end){
            end = getOrder(map, "Drink", bill);
        }
        return bill;

    }

    public static boolean getOrder(HashMap map, String type, Receipt bill){
        int num = 0;
        System.out.println(type + " Menu: ");
        for(int i = 1; i < map.size();i++){
            if(map.get(i).getClass().toString().contains(type)){
                System.out.println(i + "." + map.get(i));
                num = i;
            }
        }
        boolean move = false;
        while(!move){
            String order = requestOrder(num);
            if(order.equalsIgnoreCase("done")){
                move = true;
            }else if(order.equalsIgnoreCase("invalid")){}else{
                String[] j = order.split(" ");
                int key = Integer.parseInt(j[0]);
                int count = Integer.parseInt(j[1]);
                if(type.contains("Drink")){
                    Drink temp = (Drink) map.get(key);
                    temp.increaseCount(count);
                    bill.addItem(temp);
                } else if (type.contains("Appetizer")) {
                    Appetizer temp = (Appetizer) map.get(key);
                    temp.increaseCount(count);
                    bill.addItem(temp);
                } else if (type.contains("Entree")) {
                    Entree temp = (Entree) map.get(key);
                    temp.increaseCount(count);
                    bill.addItem(temp);
                } else if (type.contains("Dessert")) {
                    Dessert temp = (Dessert) map.get(key);
                    temp.increaseCount(count);
                    bill.addItem(temp);
                }
            }
        }
        if(move){
            if(type.contains("Drink")){
                getOrder(map, "Appetizer", bill);
            } else if (type.contains("Appetizer")) {
                getOrder(map, "Entree", bill);
            } else if (type.contains("Entree")) {
                getOrder(map, "Dessert", bill);
            }
        }
        return true;
    }

    public static String requestOrder(int num){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to order? ");
        System.out.println("Please enter the number shown next to the item to place your order or \ntype \"done\" to move on to the next menu:");
        String temp = input.next();
        String order;
        if(temp.equalsIgnoreCase("done"))
        {
            return "done";
        }else if(Integer.parseInt(temp)>0 && Integer.parseInt(temp) <= num){
            System.out.println("And how many would you like of that item?");
            try{
                order =Integer.parseInt(temp) + " " + input.nextInt();
                return order;
            }catch(InputMismatchException E){
                System.out.println("Please put in a valid response.");
                return "invalid";
            }
        }
            System.out.println("Please put in a valid number.");
            return "invalid";

    }
}