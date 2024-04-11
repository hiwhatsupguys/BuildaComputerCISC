import java.util.ArrayList;
import java.util.HashMap;

// String: its part type name, e.g. GPU
// Part: the specific type of part, e.g. RX7800XT
// Integer: how many of the part there is
public class PartInventory extends HashMap<String, HashMap<Part, Integer>> {
    
    private final GPU RX7800XT = new GPU(
            "RX 7800 XT", "AMD",
            529.99, 2023,
            2430, 16);
    
    // number of total types of parts
//    private ArrayList<String> partTypes;
    
    public PartInventory() {
        addPart(RX7800XT);
//        setPartTypes();
    }
    
    /**
     * returns the part count
     * if part is not found, returns 0.
     *
     * @param part
     * @return
     */
    public int getPartCount(Part part) {
        String partType = part.getType();
        // if the partType (e.g. "GPU") is not there, return 0
        if (!containsKey(partType)) return 0;
        
        // if it is there, get the part-count hashmap
        HashMap<Part, Integer> parts = get(partType);
        // return the count, and if the hashmap isn't there, return 0
        return parts.getOrDefault(part, 0);
    }
    
    public void setPartCount(Part part, int newCount) {
        String partType = part.getType();
        // if the partType (e.g. GPU) exists, return the hashmap. if not, return a new, empty hashmap
        HashMap<Part, Integer> parts;
        parts = getOrDefault(partType, new HashMap<>());
        // put the part with its new count into the hashmap
        parts.put(part, newCount);
        
    }
    
    /**
     * add 1 part to inventory
     * if it doesn't exist, make a new one and set its count to 0
     * if it does, increase its previous count by 1
     *
     * @param part
     */
    public void addPart(Part part) {
        // if part type exists in HM
        // if part itself exists in HM
        String partType = part.getType();
        HashMap<Part, Integer> parts = getOrDefault(partType, new HashMap<>());
        if (parts.containsKey(part)) {
            parts.put(part, parts.get(part) + 1);
        } else {
            parts.put(part, 0);
        }
    }
    
    /**
     * remove 1 part from inventory
     * if it doesn't exist, or count is already 0, do nothing. (maybe throw exception?)
     * if it does, decrease its previous count by 1
     *
     * @param part
     */
    public void removePart(Part part) {
        if (getPartCount(part) > 0) {
            setPartCount(part, getPartCount(part) - 1);
        } else {
            //@TODO maybe throw exception?
        }
    }
}
