import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Charlton Howard of 7/5/2023
 * Main class for running project
 */
public class Main {
    /**
     * Main method of class
     * @param args
     */
    public static void main(String[] args) {
        boolean morn;
        Menu a = new Menu();
        Receipt b;

        try{
            morn = a.mornCheck();
            if(morn) {
                System.out.println("Good Morning and Welcome to Outback Steakhouse!");
                System.out.println("-----------------------------------------------");
            } else{
                System.out.println("Good Evening and Welcome to Outback Steakhouse!");
                System.out.println("-----------------------------------------------");
            }
        }catch (StoreClosedException e){
            System.out.println("Sorry! The store is currently closed.");
            System.exit(-1);
        }
        a.start();
        b = showMenu(a.getMenu());
        b.printBill();


    }

    /**
     * Show menu and take orders
     * @param map the menu
     * @return bill
     */
    public static Receipt showMenu(HashMap map){
        Receipt bill = new Receipt();
        boolean end = false;

        while(!end){
            end = getOrder(map, "Drink", bill);
        }
        return bill;

    }

    /**
     * Shows menu, gets order and adds order to bill
     * @param map menu
     * @param type MenuItem type
     * @param bill Receipt
     * @return true when done
     */
    public static boolean getOrder(HashMap map, String type, Receipt bill){

        int num = 0;
        boolean first = false;
        int firstNum = 0;
        System.out.println(type + " Menu: ");
        for(int i = 1; i < map.size();i++){
            if(map.get(i).getClass().toString().contains(type)){
                if(!first) {
                    firstNum = i;
                    first=true;
                }
                System.out.println(i + "." + map.get(i));
                num = i;
            }
        }

        boolean move = false;
        while(!move){
            String order = requestOrder(num, firstNum);
            //Check if user is done with that menu type
            if(order.equalsIgnoreCase("done")){
                move = true;
            }else if(!order.equalsIgnoreCase("invalid")){
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
        if(type.contains("Drink")){
            getOrder(map, "Appetizer", bill);
        } else if (type.contains("Appetizer")) {
            getOrder(map, "Entree", bill);
        } else if (type.contains("Entree")) {
            getOrder(map, "Dessert", bill);
        }

        return true;
    }

    /**
     * Gets user input in determining order and returns the order
     * @param num max valid value
     * @param firstNum max valid value
     * @return done, order number, or invalid
     */
    public static String requestOrder(int num, int firstNum){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to order? ");
        System.out.println("Please enter the number shown next to the item to place your order(between " + firstNum + " and " + num + ") or \ntype \"done\" to move on to the next menu:");
        String temp = input.next();
        String order;
        if(temp.equalsIgnoreCase("done"))
        {
            return "done";
        }else if(Integer.parseInt(temp)>=firstNum && Integer.parseInt(temp) <= num){
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