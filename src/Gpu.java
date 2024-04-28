
// a GPU is a Part
// a GPU can Process
public class Gpu extends Part implements Processor {
    private int clockSpeedMHz;
    private int memoryGB;
    
//    public Gpu(ArrayList<String> information) {
//    }
    
    public Gpu(String name, String manufacturer, double price, int year, int clockSpeedMHz, int memoryGB) {
        super(name, manufacturer, price, year);
        this.clockSpeedMHz = clockSpeedMHz;
        this.memoryGB = memoryGB;
        setType("GPU");
    }
    
    @Override
    public String getInfo() {
        String info = super.getInfo();
        info += "\nClock Speed (MHz): " + clockSpeedMHz + "\nMemory (GB): " + memoryGB;
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
