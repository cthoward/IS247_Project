public class MenuItem{
    String name;
    String cost;
    int count = 0;
    String type;

    public MenuItem(String name, String cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }
    public String getCost(){
        return cost;
    }
    public double getCostValue(){
        String temp = cost.substring(1);
        return Double.valueOf(temp);
    }
    public String getType(){
        return type;
    }


    public void increaseCount(int i){
        count +=i;
    }

    public int getCount(){
        return count;
    }

}
