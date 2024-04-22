
/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 *
 */

public class User {
	// a User has a current balance
    
    private double balance;
    // a User has a computer
    private Computer computer;
    // is this needed in User?
    PartInventory partInventory = new PartInventory();
    private PartInventory partInventory = new PartInventory();
    
    public User() {
    
    }
    
    /**
     * getBalance:
     * This method will return the current balance of the User.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * setBalance:
     * This method will set the current balance of the User.
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public PartInventory getInventory() {
        return partInventory;
    }
    
}
