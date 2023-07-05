public class Appetizer extends MenuItem{
    public Appetizer(String name, String cost){
        super(name, cost);
        super.type = "Appetizer";

    }

    public String toString() {
        return name + " " + cost;
    }
}
