/**
 * Created by Charlton Howard of 7/5/2023
 * Appetizer class for storing appetizer information
 * Extends MenuItem
 */
public class Appetizer extends MenuItem{
    /**
     * Constructor with two String parameters
     * @param name name of Appetizer item
     * @param cost cost of Appetizer item
     */
    public Appetizer(String name, String cost){
        super(name, cost);
        super.type = "Appetizer";

    }
    /**
     * toString() method
     * @return Name and cost
     */
    public String toString() {
        return name + " " + cost;
    }
}
