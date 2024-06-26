import java.util.ArrayList;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * The Computer Class will keep track of a list of parts that when put
 * together constitute a computer.
 * A User(Customer) will buy a computer comprised of parts they have
 * selected.
 */

public class Computer {
    // a computer has parts
    private ArrayList<Part> parts;
    // has-a requiredPartTypes
    private ArrayList<String> requiredPartTypes = new ArrayList<>(PartInventory.getAllPartTypes());
    
    /**
     * The Computer constructor takes a ArrayList of type part to build the
     * computer
     */
    public Computer() {
        parts = new ArrayList<>();
    }
    
    public void addPart(Part part) {
        parts.add(part);
        requiredPartTypes.remove(part.getType());
        requiredPartTypes.sort(String::compareToIgnoreCase);
    }
    
    /**
     * A method for removing a computer part from the computer
     * @param part
     */
    public void removePart(Part part) {
        // loop over all computer's parts
        for (int i = 0; i < parts.size(); i++) {
            Part partToCheck = parts.get(i);
            // if part is the same as partToCheck
            if (part.getName().equals(partToCheck.getName())) {
                parts.remove(i);
                requiredPartTypes.add(part.getType());
                requiredPartTypes.sort(String::compareToIgnoreCase);
                return;
            }
        }
    }
    
    /**
     * This method checks if the computer has a certain kind of part inside of it, 
     * if the part type is present it will not be added.
     * @param partToCheck
     * @return true or false
     */
    public boolean hasPartType(Part partToCheck) {
        for (Part part : parts) {
            if (part.getType().equals(partToCheck.getType())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * returns an ArrayList of parts that are inside the computer
     *
     * @return parts
     */
    public ArrayList<Part> getParts() {
        return parts;
    }
    
    /**
     * checks if the computer has certain part type
     *
     * @param partToCheck
     * @return true or false depending on the search
     */
    public boolean hasPart(Part partToCheck) {
        for (Part part : parts) {
            if (part.getName().equals(partToCheck.getName())) {
                return true;
            }
        }
        return false;
    }
    
    
   /**
    * this method returns an ArrayList of strings listing all the part types that are required
    * to make a computer
    * @return requiredPartTypes
    */
    public ArrayList<String> getRequiredPartTypes() {
        
        return requiredPartTypes;
        
    }
    
    /**
     * returns true or false if the computer has all required partTypes
     *
     * @return true or false
     */
    public boolean hasRequiredPartTypes() {
        // return true if the computer needs no required part types
        return getRequiredPartTypes().isEmpty();
    }
    
    /**
     * mostly for debugging
     */
    public String toString() {
        StringBuilder info = new StringBuilder();
//        parts.sort();
        for (Part part : parts) {
            info.append(part.getType() + ": " + part.getName() + "\n");
        }
        return info.toString();
    }

//	/**
//	 * The getPerformanceRating method should return a value indicative of how a
//	 * computer is performing versus the game its
//	 * is being tested against.
//	 * 
//	 * @return
//	 */
//	public int getPerformanceRating()
//	{
//		// TODO figure out how we want to calculate a performance rating
//		return -1;
//	}
}
