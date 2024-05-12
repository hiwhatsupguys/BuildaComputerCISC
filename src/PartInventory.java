
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Additional Resources:
 * CREATING PARTS FROM FILE FUTURE RESOURCE:
 * https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
 * 
 * Class Responsibilities:
 * The PartInventory Class is responsible for keeping track of all existing parts in the computer store 
 * 
 */

public class PartInventory {
    // has a number of part types
    private int numberOfPartTypes;
    // has a inventory
    private HashMap<String, HashMap<Part, Integer>> inventory;
    // the PartInvenotry class has a list of all part types
    private static final ArrayList<Part> allParts = PartFactory.makePartsFromFile();
    
    /**
     * public Constructor for PartInventory
     */
    public PartInventory() {
    	// inventory is a HasMap
        inventory = new HashMap<>();
        // add the base parts to all partInventories
        for (Part part : allParts) {
        	// add the part to the inventory
            addPart(part);
        }
        // the number of part types is equal the size of the inventory
        numberOfPartTypes = inventory.size();
    }
    
    /**
     * @return return the type of parts in the inventory
     */
    public static ArrayList<String> getPartTypes() {
        ArrayList<String> partTypes = new ArrayList<>();
        String currentPartType = "";
        for (Part part : allParts) {
            currentPartType = part.getType();
            if (!partTypes.contains(currentPartType)) {
                partTypes.add(currentPartType);
            }
        }
        return partTypes;
//        return inventory.keySet().toArray(new String[0]);
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
    
    /**
     * set the part count of a specific part to whatever is specified.
     * @param part
     * @param newCount
     */
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
    public void decrementPartCount(Part part) {
        if (getPartCount(part) > 0) {
            setPartCount(part, getPartCount(part) - 1);
        } else {
            //@TODO maybe throw exception?
        }
    }
    
    public Part[] getPartsOfType(String partType) {
        HashMap<Part, Integer> partMap = inventory.getOrDefault(partType, new HashMap<>());
        Part[] parts = partMap.keySet().toArray(new Part[0]);
        return parts;
    }
    
    public static ArrayList<Part> getAllParts() {
        return allParts;
    }
    
    /**
     * adds all owned (part count > 0) parts to arraylist
     *
     * @return partsList
     */
    public ArrayList<Part> getAllOwnedParts() {
        ArrayList<Part> partsList = new ArrayList<>();
        for (String partType : inventory.keySet()) {
            HashMap<Part, Integer> key = inventory.get(partType);
            for (Part part : key.keySet()) {
                if (key.get(part) > 0) {
                    partsList.add(part);
                }
            }
        }
        return partsList;
    }
    
    /**
     * debug
     *
     * @return
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String partString = "";
        HashMap<Part, Integer> map;
        int count = 0;
        for (String partType : inventory.keySet()) {
            map = inventory.get(partType);
            for (Part part : map.keySet()) {
                partString = part.toString();
                count = inventory.get(partType).get(part);
                stringBuilder.append("Part: " + partString + ", Count: " + count);
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    
    public void printDebugInfo() {
        System.out.println(toString());
    }
}
