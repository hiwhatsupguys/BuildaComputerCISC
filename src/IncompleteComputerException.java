import javax.swing.*;

public class IncompleteComputerException extends RuntimeException {
    IncompleteComputerException(String message, Computer computer) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
