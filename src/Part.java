/**
 * Lead Author(s):
 * Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * The Part Superclass serves as a blueprint for more specialized Subclasses that will be used in the Computer Class.
 * Child classes of Part will
 * inherit the more general behaviors/characteristics of Part, or if necessary override specific methods for a more
 * specific purpose unique to the
 * child class. (Word this differently if you don't like the way it sound Anthony. - Elias)
 */

// the Part class is Abstract
public abstract class Part {
    
    // a Part has a name
    private final String name;
    // a Part has a manufacturer
    private final String manufacturer;
    // a Part has a Type
    private String type = "";
    // a Part has a price
    private double price;
    // a Part has a year in which is was manufactured. (correct if I'm wrong - Elias)
    private final int year;
    private String info;
    
    /**
     * Constructor for a Part
     *
     * @param name
     * @param manufacturer
     * @param price
     * @param year
     */
    public Part(String name, String manufacturer, double price, int year) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.year = year;
        info = "Name: " + this.name + ",\nManufacturer: " + this.manufacturer + ",\nPrice: "
                + this.price + ",\nYear: " + this.year;
    }

    /**
     * this makes everything infinitely easier for partFactory, see new GPU constructor in GPU class
     * @param parameters
     */
    public Part(String[] parameters) {
        this.type = parameters[0];
        this.name = parameters[1];
        this.manufacturer = parameters[2];
        this.price = Double.parseDouble(parameters[3]);
        this.year = Integer.parseInt(parameters[4]);
        info = "Name: " + this.name + ",\nManufacturer: " + this.manufacturer + ",\nPrice: "
                + this.price + ",\nYear: " + this.year;
    }

    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * makes it so when the part is parsed (for example, in the comboBox), instead of returning [Object]@1234, it will
     * return the object with its name as its string name variable (see comboBox)
     * @return the part's name
     */
    public String toString() {
        return this.getName();
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
    
    protected void setType(String type) {
        this.type = type;
    }
    
    protected String getInfo() {
        return info;
    }
}
