/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */
// a GPU is a Part
// a GPU can Process
public class GPU extends Part implements Processor {
    private int clockSpeedMHz;
    private int memoryGB;
    
//    public Gpu(ArrayList<String> information) {
//    }
    
    
    public GPU(String name, String manufacturer, double price, int year, int clockSpeedMHz, int memoryGB) {
        super(name, manufacturer, price, year);
        this.clockSpeedMHz = clockSpeedMHz;
        this.memoryGB = memoryGB;
        setType("GPU");
    }
    
    /**
     * this makes everything infinitely easier
     * @param parameters
     */
    public GPU(String[] parameters) {
        super(parameters);
        this.clockSpeedMHz = Integer.parseInt(parameters[5]);
        this.memoryGB = Integer.parseInt(parameters[6]);
    }
    
    @Override
    public String getInfo() {
        String info = super.getInfo();
        info += ",\nClock Speed (MHz): " + clockSpeedMHz + ",\nMemory (GB): " + memoryGB;
        return info;
    }
    
    @Override
    public int getClockSpeedMHz() {
        return this.clockSpeedMHz;
    }
    
    public int getMemoryGB() {
        return memoryGB;
    }
}
