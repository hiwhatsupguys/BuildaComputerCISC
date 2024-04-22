public class StoreModel {
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 *
 */

    
    // list of parts
	// private HashMap<Part, Integer> inventory = new HashMap<>();
    private PartInventory partInventory = new PartInventory();
    // number of total types of parts
    // private int numberOfPartTypes;
    // A store has a user (consider changing this to customer instead)
    private User user;
    
    private final int initialBalance = 2000;
    
    public StoreModel() {
        user = new User();
        user.setBalance(initialBalance);
    }
    
    public PartInventory getPartInventory() {
        return partInventory;
    }
    
//    /**
//     * buy the part if there is enough in stock and the user's balance is sufficient
//     *
//     * @param part
//     */
//    public void buy(Part part) {
//        double price = part.getPrice();
//        if (getPartCount(part) > 0
//                && user.getBalance() >= price) {
//            removePart(part);
//            user.setBalance(user.getBalance() - price);
//            user.addPart(part);
//        } else {
//            // decrement part count
//            // @TODO throw exception
//        }
//    }
//
//    public void sell(Part part) {
//        double price = part.getPrice();
//
//    }

//    public int getNumberOfPartTypes() {
//        return numberOfPartTypes;
//    }
//
//    public void getNumberOfPartType() {
//
//    }
    
}
