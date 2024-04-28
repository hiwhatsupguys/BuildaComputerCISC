import java.util.HashMap;
import java.util.ArrayList;
// import the parts package in src


// String: its part type name, e.g. Parts.GPU
// Part: the specific type of part, e.g. RX7800XT
// Integer: how many of the part there is
// the partInventory class is responsible for keeping track of the store's inventory.
public class PartInventory {
    
    private int numberOfPartTypes;
    private HashMap<String, HashMap<Part, Integer>> inventory;
    
    private final Gpu RX7800XT = new Gpu(
            "RX 7800 XT", "AMD",
            529.99, 2023,
            2430, 16);
    private final Cpu R77800X3D = new Cpu(
            "Ryzen 7 7800X3D", "AMD",
            382.11, 2023,
            4200);
    
    public PartInventory() {
        inventory = new HashMap<String, HashMap<Part, Integer>>();
        addPart(RX7800XT);
        addPart(R77800X3D);
        numberOfPartTypes = inventory.size();
    }
    
    /**
     * create one or more parts based on the file that creates it, and then adds it to the inventory
     * @param
     */
//    public void buildParts() {
//        // partType + Inventory, e.g. "Gpu" + "Inventory"
//        // a list of parts to be in here
//        String type = part.getType();
//        ArrayList<Part> partList = PartFactory.readPartsFromFile(type + "Inventory");
//
//    }
    
    public String[] getPartTypes() {
        return inventory.keySet().toArray(new String[0]);
    }
    
    /**
     * gets the number of the types of parts, e.g. Motherboard, Parts.GPU, CPU, etc.
     *
     * @return numberOfPartTypes
     */
    public int getNumberOfPartTypes() {
        return numberOfPartTypes;
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
        if (!inventory.containsKey(partType)) return 0;
        
        // if it is there, get the part-count hashmap
        HashMap<Part, Integer> parts = inventory.get(partType);
        // return the count, and if the hashmap isn't there, return 0
        return parts.getOrDefault(part, 0);
    }
    
    public void setPartCount(Part part, int newCount) {
        String partType = part.getType();
        // if the partType (e.g. Parts.GPU) exists, return the hashmap. if not, return a new, empty hashmap
        HashMap<Part, Integer> parts;
        parts = inventory.getOrDefault(partType, new HashMap<>());
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
        HashMap<Part, Integer> parts = inventory.getOrDefault(partType, new HashMap<>());
        if (parts.containsKey(part)) {
            parts.put(part, parts.get(part) + 1);
        } else {
            parts.put(part, 0);
        }
        inventory.put(partType, parts);
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
    
    public Part[] getPartsOfType(String partType) {
        HashMap<Part, Integer> partMap = inventory.get(partType);
        Part[] parts = partMap.keySet().toArray(new Part[0]);
        return parts;
    }
}
