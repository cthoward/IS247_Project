/**
 * Created by Charlton Howard of 7/5/2023
 * Drink class for storing drink information
 * Extends MenuItem
 */
public class Drink extends MenuItem{

    /**
     * Constructor with two String parameters
     * @param name name of Drink item
     * @param cost cost of Drink item
     */
    public Drink(String name, String cost){
        super(name, cost);
        super.type = "Drink";

    }

    /**
     * toString() method
     * @return Name and cost
     */
    @Override
    public String toString() {
        return name + " " + cost;
    }
}
