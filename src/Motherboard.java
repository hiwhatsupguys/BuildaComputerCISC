/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * The Motherboard class serves to make motherboard objects that will be used in the Computer class.
 */

// a Motherboard is a Part
public class Motherboard extends Part {
    // a Motherboard has RAMSlots;
    private int RAMSlots;
    // Might want to consider possible adding other fields for a Motherboard if we have extra time to do so.
    
    public Motherboard(String[] parameters) {
        super(parameters);
        this.RAMSlots = Integer.parseInt(parameters[5]);
    }
    
    /**
     * Constructor for a Motherboard.
     *
     * @param name
     * @param manufacturer
     * @param price
     * @param year
     * @param RAMSlots
     */
    public Motherboard(String name, String manufacturer, double price, int year, int RAMSlots) {
        super(name, manufacturer, price, year);
        this.RAMSlots = RAMSlots;
        setType("Motherboard");
    }
    
    /**
     * @return all information available on the Motherboard.
     */
    @Override
    protected String getInfo() {
        String info = super.getInfo();
        info += ",\nRam slots: " + RAMSlots;
        return info;
    }
    
}
