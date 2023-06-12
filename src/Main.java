
public class Main {
    public static void main(String[] args) {
        boolean morn;
        Menu a = new Menu();
        try{
            morn = a.mornCheck();
            if(morn) {
                System.out.println("Displaying Breakfast Menu");
            } else{
                System.out.println("Displaying Dinner Menu");
            }
        } catch (StoreClosedException e){
            System.out.println("Sorry! The store is currently closed.");
            System.exit(-1);
        }
        System.out.println("Hi");


    }
}