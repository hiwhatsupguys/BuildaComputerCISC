
/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

public class User {
    // a User has a current balance
    private double balance;
    // a User has a computer
    private Computer computer;
    // the user could have a separate inventory of parts, for example, if they want to swap parts
    private PartInventory partInventory = new PartInventory();
    
    public User() {
        computer = new Computer();
    }
    
    /**
     * getBalance:
     * This method will return the current balance of the User.
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * setBalance:
     * This method will set the current balance of the User.
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * returns user's part inventory
     * @return partInventory
     */
    public PartInventory getInventory() {
        return partInventory;
    }
    
    /**
     * returns the computer a user has
     * @return computer
     */
    public Computer getComputer() {
        return computer;
    }
    
}
