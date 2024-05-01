import java.util.ArrayList;

public class StoreModel {
    
    /**
     * Lead Author(s):
     *
     * @author Anthony Bazalaki, Elias Zarate
     * <p>
     * Class Responsibilities:
     */
    
    
    // list of parts
    // private HashMap<Part, Integer> inventory = new HashMap<>();
    private PartInventory partInventory = new PartInventory();
    // number of total types of parts
    // private int numberOfPartTypes;
    // A store has a user (consider changing this to customer instead)
    private User user;
    
    private final int initialBalance;
    private int initialStoreStock = 3;
    
    public StoreModel() {
        user = new User();
        initialBalance = 2000;
        user.setBalance(initialBalance);
        ArrayList<Part> allParts = PartInventory.getAllParts();
        for (Part part : allParts) {
            // add each part (initialStoreStock) times
            for (int i = 0; i < initialStoreStock; i++) {
                partInventory.addPart(part);
            }
        }
    }
    
    public PartInventory getPartInventory() {
        return partInventory;
    }
    
    /**
     * buy the part if there is enough in stock and the user's balance is sufficient
     *
     * @param part
     */
    public void buy(Part part) {
        double balance = user.getBalance();
        double price = part.getPrice();
        // if the user is too poor
        if (balance < price) {
            // throw error or something
            return;
        }
        // decrease balance
        user.setBalance(balance - price);
        // decrease store's part count
        partInventory.decrementPartCount(part);
        // increase user part count
        user.getInventory().addPart(part);
    }
    
    public void sell(Part part) {
        double balance = user.getBalance();
        double price = part.getPrice();
        // if the user doesn't have the part
        if (user.getInventory().getPartCount(part) <= 0) {
            // throw error or something
            return;
        }
        user.setBalance(balance + price);
        partInventory.addPart(part);
        user.getInventory().decrementPartCount(part);
    }
    
    public User getUser() {
        return user;
    }
}
