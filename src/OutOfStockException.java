/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * in the event an item the user is looking to purchase is out of stock
 */

public class OutOfStockException extends Exception
{
	public OutOfStockException(Part item)
	{
		super("Error: The item" + item + " is out of stock");
	}
}
