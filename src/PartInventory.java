
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Additional Resources:
 * CREATING PARTS FROM FILE FUTURE RESOURCE:
 * https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
 * <p>
 * Class Responsibilities:
 * The PartInventory Class is responsible for keeping track of all existing parts in the computer store
 */

public class PartInventory {
    // has a number of part types
    private int numberOfPartTypes;
    // has a inventory
    private HashMap<Part, Integer> inventory;
    // the PartInvenotry class has a list of all part types
    private static final ArrayList<Part> ALL_PARTS = PartFactory.makePartsFromFile();
    
    /**
     * public Constructor for PartInventory
     */
    public PartInventory() {
        // inventory is a HasMap
        inventory = new HashMap<>();
        // add the base parts to all partInventories
//        for (Part part : getAllParts()) {
//            // add the part to the inventory
//            addPart(part);
//        }
        // the number of part types is equal the size of the inventory
    }
    
    public ArrayList<Part> getParts() {
        return new ArrayList<>(inventory.keySet());
    }
    
    public Part getPart(String partName) {
        for (Part part : inventory.keySet()) {
            if (part.getName().equals(partName)) return part;
        }
        throw new NullPointerException("part not found");
    }
    
    public Part getPart(Part part) throws NullPointerException {
        if (containsPart(part)) {
            return part;
        }
        throw new NullPointerException("part not found");
    }
    
    public boolean containsPart(Part part) {
        for (Part partToCheck : getParts()) {
            if (partToCheck.equals(part)) return true;
        }
        return false;
    }
    
    
    /**
     * @return return the type of parts in the inventory
     */
    public String[] getPartTypes() {
        ArrayList<String> partTypes = new ArrayList<>();
        ArrayList<Part> parts = getParts();
        for (Part part : parts) {
            String partType = part.getType();
            if (!partTypes.contains(partType)) {
                partTypes.add(partType);
            }
        }
        return partTypes.toArray(new String[0]);
    }
    
    public static ArrayList<String> getAllPartTypes() {
        ArrayList<String> partTypes = new ArrayList<>();
        for (Part part : ALL_PARTS) {
            String partType = part.getType();
            if (!partTypes.contains(partType)) {
                partTypes.add(partType);
            }
        }
        return partTypes;
    }
    
    public int getNumberOfPartTypes() {
        return this.getPartTypes().length;
    }
    
    
    /**
     * gets the number of the types of parts, e.g. Motherboard, GPU, CPU, etc.
     *
     * @return numberOfPartTypes
     */
    public static int getTotalNumberOfPartTypes() {
        return getAllPartTypes().size();
    }
    
    /**
     * returns the part count
     * if part is not found, returns 0.
     *
     * @param part
     * @return
     */
    public int getPartCount(Part part) {
        if (containsPart(part)) {
            return inventory.getOrDefault(getPart(part), 0);
        }
        return 0;
    }
    
    /**
     * set the part count of a specific part to whatever is specified.
     *
     * @param part
     * @param newCount
     */
    public void setPartCount(Part part, int newCount) {
        // puts in new part if doesn't contain, puts in new count if does contain
        if (containsPart(part)) {
            // if the part is already in inventory, only change the count of the part that is in there
            part = getPart(part);
        }
        inventory.put(part, newCount);
        
    }
    
    /**
     * add 1 part to inventory
     * if it doesn't exist, make a new one and set its count to 0
     * if it does, increase its previous count by 1
     *
     * @param part
     */
    public void addPart(Part part) {
        // CHANGE (maybe need to add the part from ALL_PARTS instead)
        if (containsPart(part)) {
            Part partInInventory = getPart(part);
            int previousCount = inventory.get(partInInventory);
            setPartCount(partInInventory, previousCount + 1);
        } else {
            inventory.put(part, 1);
        }
    }
    
    public void removePart(Part part) {
        Part partInInventory = getPart(part);
        inventory.remove(partInInventory);
    }
    
    /**
     * remove 1 part from inventory
     * if it doesn't exist, or count is already 0, do nothing. (maybe throw exception?)
     * if it does, decrease its previous count by 1
     *
     * @param part
     */
    public void decrementPartCount(Part part) {
        Part partInInventory = getPart(part);
        int partCount = getPartCount(partInInventory);
        if (partCount <= 1) {
            removePart(part);
        } else {
            setPartCount(partInInventory, partCount - 1);
        }
    }
    
    public ArrayList<Part> getPartsOfType(String partType) {
        ArrayList<Part> partsOfType = new ArrayList<>();
        for (Part part : getParts()) {
            if (part.getType().equals(partType)) {
                partsOfType.add(part);
            }
        }
        return partsOfType;
    }
    
    public static ArrayList<Part> getAllParts() {
        return ALL_PARTS;
    }
    
    /**
     * adds all owned (part count > 0) parts to arraylist
     *
     * @return partsList
     */
    public ArrayList<Part> getAllOwnedParts() {
        return null;
    }
    
    /**
     * debug
     *
     * @return
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Part part : getParts()) {
            stringBuilder.append("Part: " + part.getName() + ", Count: " + getPartCount(part));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    
    public void printDebugInfo() {
        System.out.println(toString());
    }
}
