/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

// RAM is a Part
public class Ram extends Part {
    // RAM has memory
    private int memoryGB;
    
    public Ram(String[] parameters) {
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
    public Ram(String name, String manufacturer, double price, int year, int memory) {
        super(name, manufacturer, price, year);
        this.memoryGB = memory;
        setType("RAM");
    }
    
    /**
     *
     */
    @Override
    protected String getInfo() {
        String info = super.getInfo();
        info += ",\nMemory: " + memoryGB;
        return info;
    }
    
}
