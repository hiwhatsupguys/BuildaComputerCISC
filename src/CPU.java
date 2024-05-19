/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * The CPU class serves to make CPU objects that will be used in a Computer Class Object (a computer).
 */

// a CPU is a Part
public class CPU extends Part implements Processor
{
	// a CPU has a clock speed 
	private int clockSpeedMHz;
	
	/**
	 * Constructor
	 * @param clockSpeedMHz
	 */
	public CPU(String name, String manufacturer, double price, int year, int clockSpeedMHz)
	{
		super(name, manufacturer, price, year);
		this.clockSpeedMHz = clockSpeedMHz;
		setType("CPU");
	}
	
	/**
	 * this makes everything infinitely easier
	 * @param parameters
	 */
	public CPU(String[] parameters) {
		super(parameters);
		this.clockSpeedMHz = Integer.parseInt(parameters[5]);
	}

	/**
	 * return the clockspeed of a cpu
	 * 
	 * @return clockSpeedMhz
	 */
	@Override
	public int getClockSpeedMHz()
	{
		return clockSpeedMHz;
	}

	/**
	 * returns all relevant information on the computer part
	 * @return info
	 */
	@Override
	protected String getInfo()
	{
		String info = super.getInfo();
		info += "\nClock Speed (MHz): " + clockSpeedMHz;
		return info;
	}

}
