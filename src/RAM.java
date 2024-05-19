/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

// RAM is a Part
public class RAM extends Part {
	
    // RAM has a memory size
    private int memoryGB;
    
    /**
     * Constructor for the purposes of building a RAM object via the use of file I/O.
     * @param parameters
     */
    public RAM(String[] parameters) {
        super(parameters);
        this.memoryGB = Integer.parseInt(parameters[5]);
    }
    
    /**
     * RAM class Constructor.
     *
     * @param name
     * @param manufacturer
     * @param price
     * @param year
     * @param memory
     */
    public RAM(String name, String manufacturer, double price, int year, int memory) {
        super(name, manufacturer, price, year);
        this.memoryGB = memory;
        setType("RAM");
    }
    
    /**
     * the getInfo() method returns all information pertaining to a RAM object.
     *@return info
     */
    @Override
    protected String getInfo() {
        String info = super.getInfo();
        info += "\nMemory: " + memoryGB;
        return info;
    }
    
}
