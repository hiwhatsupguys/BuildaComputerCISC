import java.util.ArrayList;
import java.util.HashMap;

public class User {
    
    private double balance;
    private Computer computer;
    private PartInventory partInventory = new PartInventory();
    
    public User() {
    
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public PartInventory getInventory() {
        return partInventory;
    }
    
}
