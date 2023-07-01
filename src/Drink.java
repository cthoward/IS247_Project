public class Drink extends MenuItem{


    public Drink(String name, String cost){
        super(name, cost);
        super.type = "Drink";

    }


    @Override
    public String toString() {
        return name + " " + cost;
    }
}
