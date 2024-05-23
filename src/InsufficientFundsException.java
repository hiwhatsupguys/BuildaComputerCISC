/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * in the event a user does not have sufficient enough funds to purchase the computer
 * Unimplemented as of final week of project, We decided to drop this kind of feature.
 * A User now has more funds and can return items to the computer shop in the event they run out of funds.
 */


public class InsufficientFundsException extends RuntimeException
{
	public InsufficientFundsException(double amount, double owed)
	{
		super("Error: Insufficient funds," + amount + " is not enough, a total of" + owed + " is needed");
	}

}
