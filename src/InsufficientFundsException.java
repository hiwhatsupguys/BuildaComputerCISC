/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * in the even a user does not have sufficient enough funds to purchase the computer
 */


public class InsufficientFundsException extends Exception
{
	public InsufficientFundsException(double amount, double owed)
	{
		super("Error: Insufficient funds," + amount + " is not enough, a total of" + owed + " is needed");
	}

}
