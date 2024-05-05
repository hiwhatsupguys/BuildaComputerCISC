/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */
// a GPU is a Part
// a GPU can Process/ is a Processor
public class GPU extends Part implements Processor {
    private int clockSpeedMHz;
    private int memoryGB;
    
    /**
     * public constructor for a GPU
     * @param name
     * @param manufacturer
     * @param price
     * @param year
     * @param clockSpeedMHz
     * @param memoryGB
     */
    public GPU(String name, String manufacturer, double price, int year, int clockSpeedMHz, int memoryGB) {
        super(name, manufacturer, price, year);
        this.clockSpeedMHz = clockSpeedMHz;
        this.memoryGB = memoryGB;
        setType("GPU");
    }
    
    /**
     * public Overloaded constructor for a GPU that takes an array of parameters and initializes all relevant fields
     * @param parameters
     */
    public GPU(String[] parameters) {
        super(parameters);
        this.clockSpeedMHz = Integer.parseInt(parameters[5]);
        this.memoryGB = Integer.parseInt(parameters[6]);
    }
    
    /**
     * returns all relevant information on a GPU
     * @return info
     */
    @Override
    public String getInfo() {
        String info = super.getInfo();
        info += ",\nClock Speed (MHz): " + clockSpeedMHz + ",\nMemory (GB): " + memoryGB;
        return info;
    }
    
    /**
     * returns the clockSpeedMHz of a GPU
     * @return this.clockSpeedMHz
     */
    @Override
    public int getClockSpeedMHz() {
        return this.clockSpeedMHz;
    }
    
    /**
     * returns the amount of memory a GPU has 
     * @return memoryGB
     */
    public int getMemoryGB() {
        return memoryGB;
    }
}
