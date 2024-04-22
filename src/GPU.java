public class GPU extends Part implements Processor {
    private int clockSpeedMHz;
    private int memoryGB;
    
    
    public GPU(String name, String manufacturer, double price, int year, int clockSpeedGHz, int memoryGB) {
        super(name, manufacturer, price, year);
        this.clockSpeedMHz = clockSpeedGHz;
        this.memoryGB = memoryGB;
        setType("Parts.GPU");
    }
    
    @Override
    protected String getInfo() {
        return "";
    }
    
    @Override
    public int getClockSpeedMHz() {
        return this.clockSpeedMHz;
    }
    
    public int getMemoryGB() {
        return memoryGB;
    }
}
