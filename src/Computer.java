import java.util.ArrayList;

/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
   The Computer Class will keep track of a list of parts that when put together constitute a computer.
   AU User(Customer) will buy a computer comprised of parts they have selected.
 * 
 */

public class Computer 
{
	// a computer has parts
    private ArrayList<Part> computerParts;
    
    /**
     * The Computer constructor takes a ArrayList of type part to build the computer
     * @param partsList
     */
    public Computer(ArrayList<Part> partsList)
    {
    	computerParts = partsList;
    }
    
    /**
     * The getPerformanceRating method should return a value indicative of how a computer is performing versus the game its 
     * is being tested against.
     * @return
     */
    // @param of game passed to the method?
    public int getPerformanceRating()
    {
    	//TODO figure out how we want to calculate a performance rating
    	return -1;
    }
}
