/**
 * Created by Charlton Howard of 7/5/2023
 * Entree class for storing entree information
 * Extends MenuItem
 */
public class Entree extends MenuItem{
    /**
     * Constructor with two String parameters
     * @param name name of Entree item
     * @param cost cost of Entree item
     */
    public Entree(String name, String cost){
        super(name, cost);
        super.type = "Entree";
    }
    /**
     * toString() method
     * @return Name and cost
     */
    public String toString() {
        return name + " " + cost;
    }
}
