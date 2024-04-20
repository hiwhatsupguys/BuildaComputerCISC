/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */


public class InsufficientFundsException extends Exception
{
	public InsufficientFundsException(double amount, double owed)
	{
		super("Error: Insufficient funds," + amount + " is not enough, a total of" + owed + " is needed");
	}

}
