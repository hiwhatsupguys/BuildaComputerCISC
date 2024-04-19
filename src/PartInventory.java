import java.util.ArrayList;
import java.util.HashMap;

public class PartInventory extends HashMap<Part, Integer> {
    
    Gpu RX7800XT = new Gpu(
            "RX 7800 XT", "AMD",
            529.99, 2023,
            2430, 16);
    
    private int numberOfPartTypes;
    
    public PartInventory() {
        addPart(RX7800XT);
        calculateNumberOfPartTypes();
    }
    
    /**
     * returns the part count
     * if part is not found, returns 0.
     *
     * @param part
     * @return
     */
    public int getPartCount(Part part) {
        return getOrDefault(part, 0);
    }
    
    private void setPartCount(Part part, int newCount) {
        // might not work because of reference types
        put(part, newCount);
    }
    
    /**
     * add 1 part to inventory
     * if it doesn't exist, make a new one and set its count to 0
     * if it does, increase its previous count by 1
     *
     * @param part
     */
    private void addPart(Part part) {
        if (containsKey(part)) {
            setPartCount(part, getPartCount(part) + 1);
        } else {
            setPartCount(part, 0);
        }
    }
    
    /**
     * remove 1 part from inventory
     * if it doesn't exist, or count is already 0, do nothing. (maybe throw exception?)
     * if it does, decrease its previous count by 1
     *
     * @param part
     */
    private void removePart(Part part) {
        if (getPartCount(part) > 0) {
            setPartCount(part, getPartCount(part) - 1);
        } else {
            //@TODO maybe throw exception?
        }
    }
    
    /**
     * Calculates the number of unique part types
     */
    public void calculateNumberOfPartTypes() {
        ArrayList<String> foundTypes = new ArrayList<>();
        String currentType;
        for (Part part : keySet()) {
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
