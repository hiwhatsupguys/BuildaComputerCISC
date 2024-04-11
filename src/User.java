import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private double balance;
    
    private Computer computer;
    PartInventory partInventory = new PartInventory();
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
