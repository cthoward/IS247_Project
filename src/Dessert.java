/**
 * Created by Charlton Howard of 7/5/2023
 * Dessert class for storing dessert information
 * Extends MenuItem
 */
public class Dessert extends MenuItem{
    /**
     * Constructor with two String parameters
     * @param name name of Dessert item
     * @param cost cost of Dessert item
     */
    public Dessert(String name, String cost){
        super(name, cost);
        super.type = "Dessert";
    }

    /**
     * toString() method
     * @return Name and cost
     */
    public String toString() {
        return name + " " + cost;
    }
}
