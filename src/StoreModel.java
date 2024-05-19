import java.util.ArrayList;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * StoreModel will handle all logic that is need for the program to work
 */
public class StoreModel {
    
    // list of parts
    // private HashMap<Part, Integer> inventory = new HashMap<>();
    private PartInventory storeInventory = new PartInventory();
    // number of total types of parts
    // private int numberOfPartTypes;
    // A store has a user (consider changing this to customer instead)
    private User user;
    // a StoreModel has a final initial balance
    private final int initialBalance;
    // a StoreModel has an initial stock of 3
    private int initialStoreStock = 3;
    private PartInventory userInventory;
    
    public StoreModel() {
        user = new User();
        initialBalance = 4000;
        user.setBalance(initialBalance);
        userInventory = user.getInventory();
        ArrayList<Part> allParts = PartInventory.getAllParts();
        for (Part part : allParts) {
            // add each part (initialStoreStock) times
            storeInventory.setPartCount(part, initialStoreStock);
//            for (int i = 0; i < initialStoreStock; i++) {
//                storeInventory.addPart(part);
//            }
        }
    }
    
    /**
     * returns the parts inventory
     *
     * @return partInventory
     */
    public PartInventory getStoreInventory() {
        return storeInventory;
    }
    
    /**
     * buy the part if there is enough in stock and the user's balance is sufficient
     *
     * @param part
     */
    public void buy(Part part) {
        double balance = user.getBalance();
        double price = part.getPrice();
        int storePartCount = storeInventory.getPartCount(part);
        // if the user is too poor or the store doesn't have more parts
        if (balance < price || storePartCount <= 0) {
            // throw error or something
            return;
        }
        // decrease balance
        user.setBalance(balance - price);
        // decrease store's part count
        storeInventory.decrementPartCount(part);
        // increase user part count
        userInventory.addPart(part);
    }
    
    /**
     * this method allows the user to return a part they no longer desire
     *
     * @param part
     */
    public void sell(Part part) {
        double balance = user.getBalance();
        double price = part.getPrice();
        Computer computer = user.getComputer();
        // if the user doesn't have the part
        if (userInventory.getPartCount(part) <= 0) {
            // throw error or something
            return;
        }
        user.setBalance(balance + price);
        storeInventory.addPart(part);
        userInventory.decrementPartCount(part);
        if (!userInventory.containsPart(part) && computer.hasPart(part)) {
            computer.removePart(part);
        }
        
    }
    
    /**
     * this method returns the user of the StoreModel
     *
     * @return user
     */
    public User getUser() {
        return user;
    }
}
