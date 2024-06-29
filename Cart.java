import java.util.ArrayList;
import java.util.List;

public class Cart {
    // Defining lists for different types of items in the cart
    private List<PhoneCharm> phoneCharmItems;
    private List<phoneCase> phoneCaseItems;
    private List<AirpodCase> airpodCaseItems;
    private List<WatchBand> watchBandItems;

    // Constructor initializing the item lists
    public Cart() {
        phoneCharmItems = new ArrayList<>();
        phoneCaseItems = new ArrayList<>();
        airpodCaseItems = new ArrayList<>();
        watchBandItems = new ArrayList<>();
    }

    // Methods to add items to the cart
    public void addItem(PhoneCharm item) {
        phoneCharmItems.add(item);
    }
    public void addItem(phoneCase item) {
        phoneCaseItems.add(item);
    }
    public void addItem(AirpodCase item) {
        airpodCaseItems.add(item);
    }
    public void addItem(WatchBand item) {
        watchBandItems.add(item);
    }

    // Methods to remove items from the cart
    public void removeItem(PhoneCharm item) {
        phoneCharmItems.remove(item);
    }
    public void removeItem(phoneCase item) {
        phoneCaseItems.remove(item);
    }
    public void removeItem(AirpodCase item) {
        airpodCaseItems.remove(item);
    }
    public void removeItem(WatchBand item) {
        watchBandItems.remove(item);
    }

    // Methods to get the lists of items in the cart
    public List<PhoneCharm> getPhoneCharmItems() {
        return phoneCharmItems;
    }
    public List<phoneCase> getPhoneCaseItems() {
        return phoneCaseItems;
    }
    public List<AirpodCase> getAirpodCaseItems() {
        return airpodCaseItems;
    }
    public List<WatchBand> getWatchBandItems() {
        return watchBandItems;
    }
}