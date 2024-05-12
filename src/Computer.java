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
    
    /**
     * The Computer constructor takes a ArrayList of type part to build the
     * computer
     */
    public Computer() {
        parts = new ArrayList<>();
    }
    
    public void addPart(Part part) {
        parts.add(part);
    }
    
    public void removePart(Part part) {
        for (int i = 0; i < parts.size(); i++) {
            Part partToCheck = parts.get(i);
            // if part is the same as partToCheck
            if (part.getName().equals(partToCheck.getName())) {
                parts.remove(i);
                return;
            }
        }
    }
    
    /**
     * returns an ArrayList of parts that are inside the computer
     * @return parts
     */
    public ArrayList<Part> getParts() {
        return parts;
    }
    
    /**
     * checks if the computer has certain part type
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
