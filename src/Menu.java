import java.util.Date;
public class Menu {

    public boolean mornCheck() throws StoreClosedException {
        Date a = new Date();
        if(a.getHours() < 13 && a.getHours() > 8){
            return true;
        } else if(a.getHours()>= 13 && a.getHours() < 15){
            return false;
        } else{
            throw new StoreClosedException();
        }

    }
}

class StoreClosedException extends Exception {

}