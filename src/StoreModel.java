import java.util.ArrayList;
import java.util.HashMap;

public class StoreModel {
    
    // list of parts
//    private HashMap<Part, Integer> inventory = new HashMap<>();
    private PartInventory partInventory = new PartInventory();
    // number of total types of parts
//    private int numberOfPartTypes;
    private User user;
    private final int initialBalance = 2000;
    
    public StoreModel() {
        user = new User();
        user.setBalance(initialBalance);
//        addPart(RX7800XT);
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
