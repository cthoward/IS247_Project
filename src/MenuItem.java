/**
 * Created by Charlton Howard of 7/5/2023
 * MenuItem class for storing menu item information
 */
public class MenuItem{
    protected String name;
    protected String cost;
    protected int count = 0;
    protected String type;
    /**
     * Constructor with two String parameters
     * @param name name of item
     * @param cost cost of item
     */
    public MenuItem(String name, String cost){
        this.name = name;
        this.cost = cost;
    }

    /**
     * Display Name
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Display Cost
     * @return cost
     */
    public String getCost(){
        return cost;
    }
    /**
     * Display Type
     * @return type
     */
    public String getType(){
        return type;
    }
    /**
     * Display Count
     * @return count
     */
    public int getCount(){
        return count;
    }

    /**
     * Adds Integer parameter to count value
     * @param i number to add to count
     */
    public void increaseCount(int i){
        count +=i;
    }

    /**
     * Returns the cost value as a Double
     * @return cost as Double
     */
    public double getCostValue(){
        String temp = getCost().substring(1);
        return Double.parseDouble(temp);
    }



}
