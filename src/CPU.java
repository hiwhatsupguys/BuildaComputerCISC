/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
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
	 * Overclock the CPU?
	 * Note for Anthony: are we overclocking the CPU or?
	 * @return clockSpeedMhz
	 */
	@Override
	public int getClockSpeedMHz()
	{
		return clockSpeedMHz;
	}

	
	@Override
	protected String getInfo()
	{
		String info = super.getInfo();
		info += ",\nClock Speed (MHz): " + clockSpeedMHz;
		return info;
	}

}
