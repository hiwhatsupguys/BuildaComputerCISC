import java.util.ArrayList;
import java.util.HashMap;

public class StoreModel {
    
    // list of parts
    private HashMap<Part, Integer> inventory = new HashMap<>();
    // number of total types of parts
    private int numberOfPartTypes;
    private User user;
    private final int initialBalance = 2000;
    
    public StoreModel() {
        // adding parts
        GPU RX7800XT = new GPU(
                "RX 7800 XT", "AMD",
                529.99, 2023,
                2430, 16);
        user = new User();
        user.setBalance(initialBalance);
        addPart(RX7800XT);
        calculateNumberOfPartTypes();
    }
    
    /**
     * returns the part count
     * if part is not found, returns 0.
     * @param part
     * @return
     */
    public int getPartCount(Part part) {
        return inventory.getOrDefault(part, 0);
    }
    
    private void setPartCount(Part part, int newCount) {
        // might not work because of reference types
        inventory.put(part, newCount);
    }
    
    /**
     * add 1 part to inventory
     * if it doesn't exist, make a new one and set its count to 1
     * if it does, increase its previous count by 1
     *
     * @param part
     */
    private void addPart(Part part) {
        setPartCount(part, getPartCount(part) + 1);
    }
    
    /**
     * remove 1 part from inventory
     * if it doesn't exist, or count is already 0, do nothing. (maybe throw exception?)
     * if it does, decrease its previous count by 1
     *
     * @param part
     */
    private void removePart(Part part) {
        if (getPartCount(part)>0) {
            setPartCount(part, getPartCount(part) - 1);
        } else {
            //@TODO maybe throw exception?
        }
    }
    
    
    /**
     * buy the part if there is enough in stock and the user's balance is sufficient
     * @param part
     */
    public void buy(Part part) {
        if (getPartCount(part) > 0
                && user.getBalance() >= part.getPrice()) {
            // @TODO give part to the user
        } else {
            // decrement part count
            // @TODO throw exception
        }
    }
    
    public void sell(Part part) {
    
    }
    
    public int getNumberOfPartTypes() {
        return numberOfPartTypes;
    }
    
    public void getNumberOfPartType() {
    
    }
    
    /**
     * Calculates the number of unique part types
     */
    public void calculateNumberOfPartTypes() {
        if (inventory == null) return;
        ArrayList<String> foundTypes = new ArrayList<>();
        String currentType;
        for (Part part : inventory.keySet()) {
            currentType = part.getType();
            // if the type hasn't already been found
            if (!foundTypes.contains(currentType)) {
                foundTypes.add(currentType);
                numberOfPartTypes++;
            }
        }
        System.out.println(numberOfPartTypes);
    }
    
}
