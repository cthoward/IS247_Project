public class Dessert extends MenuItem{
    public Dessert(String name, String cost){
        super(name, cost);
        super.type = "Dessert";
    }

    public String toString() {
        return name + " " + cost;
    }
}
