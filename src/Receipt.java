import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Receipt {
    List<MenuItem> bill = new ArrayList<>();
    double total = 0;
    public Receipt(){}

    public void addItem(MenuItem a){
        bill.add(a);
    }

    public void printBill(){
        System.out.println("----Bill----");
        for (int i = 0; i < bill.size(); i++){
            MenuItem temp = bill.get(i);
            System.out.println("Count: " + temp.getCount() + " Name: " + temp.getName() + " Cost: $" + (temp.getCount()*temp.getCostValue()));
            total += temp.getCount()*temp.getCostValue();
        }
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Total Cost: $" + total);
        double taxCost = Math.round(total * 0.06 * 100.0)/100.0;
        System.out.println("Tax(6%): $" + taxCost);
        int tip = askTip();
        double tipCost = Math.round(total * tip)/100.0;
        System.out.println("Tip(" + tip + "%): $" + tipCost);
        System.out.println("Final total: $" + (total + taxCost + tipCost));
    }
    public int askTip(){
        int tip = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to include a tip? \n(Please type tip percentage as a whole number):");
        tip = input.nextInt();
        return tip;
    }
}
