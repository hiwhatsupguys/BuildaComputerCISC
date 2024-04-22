/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */

// a CPU is a Part
public class Cpu extends Part implements Processor
{
	// a CPU has a clock speed 
	private int clockSpeedMhz;
	
	/**
	 * Constructor
	 * @param clockSpeed
	 */
	public Cpu(String name, String manufacturer, double price, int year, int clockSpeed)
	{
		super(name, manufacturer, price, year);
		this.clockSpeedMhz = clockSpeed;
		setType("CPU");
	}

	/**
	 * Overclock the CPU?
	 * Note for Anthony: are we overclocking the CPU or?
	 * @return clockSpeedMhz
	 */
	@Override
	public int getClockSpeedMHz()
	{
		return clockSpeedMhz;
	}

	
	@Override
	protected String getInfo()
	{
		// TODO Auto-generated method stub (implement the info)
		return "";
	}

}
