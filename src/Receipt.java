import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Charlton Howard of 7/5/2023
 * Receipt class for returning the bill
 */
public class Receipt {
    List<MenuItem> bill = new ArrayList<>();
    double total = 0;

    /**
     * Basic constructor
     */
    public Receipt(){}

    /**
     * Adds MenuItem to bill ArrayList
     * @param a MenuItem
     */
    public void addItem(MenuItem a){
        bill.add(a);
    }

    /**
     * Prints Bill
     */
    public void printBill(){
        System.out.println("----Bill----");
        consolidateBill();
        String currentType ="";
        for (MenuItem a: bill ) {
            if(!a.getType().equalsIgnoreCase(currentType)){
                currentType = a.getType();
                System.out.println(currentType + "-----");
            }
            System.out.println("Count: " + a.getCount() + " Name: " + a.getName() + " Cost: $" + (a.getCount()*a.getCostValue()));
            total += a.getCount()*a.getCostValue();

        }
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Total Cost: $" + total);
        double taxCost = Math.round(total * 0.06 * 100.0)/100.0;
        System.out.println("Tax(6%): $" + taxCost);
        int tip = -1;
        System.out.println("Would you like to include a tip? \n(Please type tip percentage as a whole number):");
        while(tip < 0){
            try{
                tip = askTip();
            }catch(InvalidTipNumber E){
                System.out.println("That is not a valid tip percentage. Please try again.");
            }
        }
        double tipCost = Math.round(total * tip)/100.0;
        System.out.println("Tip(" + tip + "%): $" + tipCost);
        System.out.println("Final total: $" + Math.round((total + taxCost + tipCost)*100.0)/100.0);
    }

    /**
     * Asks if user wants to tip
     * @return tip percentage
     * @throws InvalidTipNumber Invalid tip entered
     */
    private int askTip() throws InvalidTipNumber{
        int tip;
        Scanner input = new Scanner(System.in);
        try{
            tip = input.nextInt();
        }catch (InputMismatchException E){
            throw new InvalidTipNumber();
        }
        if(tip<0){
            throw new InvalidTipNumber();
        }
        return tip;
    }

    /**
     * Merges similar items in ArrayList bill
     */
    private void consolidateBill(){
        for(int i = 0; i < bill.size();i++)
            for (int j = i + 1; j < bill.size(); j++)
                if (bill.get(i).getName().equalsIgnoreCase(bill.get(j).getName())) {
                    bill.remove(j);
                    j--;
                }
    }
}

/**
 * Custom Exception for an invalid tip entry
 */
class InvalidTipNumber extends Exception{

}
