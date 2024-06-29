import java.sql.Array;
import java.util.*;

public class storehouse {

    private ArrayList<String> phoneCase ; // List for phone cases
    private ArrayList<String> phoneCaseInventory;
    private ArrayList<String> airpodCase ;
    private ArrayList<String> phoneCharm;
    private ArrayList<String> watchBands ;

    public storehouse ()
    {
        phoneCase = new ArrayList<>(); // Initialize phone case list
        airpodCase = new ArrayList<>();
        phoneCharm = new ArrayList<>();
        watchBands = new ArrayList<>();

    }

    // Getter for watch bands list
    public ArrayList<String> getWatchBands() {
        return watchBands;
    }

    // Getter for airpod cases list
    public ArrayList<String> getAirpodCase(){
        return airpodCase;
    }

    // Getter for phone cases list
    public ArrayList<String> getPhoneCase(){
        return phoneCase;
    }

    // Getter for phone charms list
    public ArrayList <String> getPhoneCharm (){
        return phoneCharm;
    }

}
