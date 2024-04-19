/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 */

// RAM is a Part
public class Ram extends Part
{
	// RAM has memory
	private int memory;
	
	/**
	 * RAM class Constructor.
	 * @param name
	 * @param manufacturer
	 * @param price
	 * @param year
	 * @param memory
	 */
	public Ram(String name, String manufacturer, double price, int year, int memory)
	{
		super(name, manufacturer, price, year);
		this.memory = memory;
		setType("RAM");
	}

	/**
	 * 
	 */
	@Override
	protected String getInfo()
	{
		// TODO Auto-generated method stub
		return "";
	}
	
}
