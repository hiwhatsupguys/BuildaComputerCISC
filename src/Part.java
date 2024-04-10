public abstract class Part {
    private final String name;
    private final String manufacturer;
    private final String type;
    private double price;
    private final int year;
    
    public Part(String name, String manufacturer, String type, double price, int year) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.year = year;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public String getType() {
        return type;
    }
    
    public int getYear() {
        return year;
    }
    
    protected abstract String getInfo();
}
