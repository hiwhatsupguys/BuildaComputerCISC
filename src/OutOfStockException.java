/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */

public class OutOfStockException extends Exception
{
	public OutOfStockException(Part item)
	{
		super("Error: The item" + item + " is out of stock");
	}
}
