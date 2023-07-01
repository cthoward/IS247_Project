public class Entree extends MenuItem{
    public Entree(String name, String cost){
        super(name, cost);
        super.type = "Entree";
    }

    public String toString() {
        return name + " " + cost;
    }
}
