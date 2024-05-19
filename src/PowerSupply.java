/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 *
 */
public class PowerSupply extends Part {
    
    // PowerSupply has powerEfficiency
    private String powerEfficiency;
    
    /**
     * public Constructor for a PowerSupply Object
     *@param parameters
     */
    public PowerSupply(String[] parameters) {
        super(parameters);
        this.powerEfficiency = parameters[5];
    }
    
    /**
     *@return info on a power supply
     */
    @Override
    protected String getInfo() {
        String info = super.getInfo();
        info += "\nPower Efficiency: " + powerEfficiency;
        return info;
    }
}
