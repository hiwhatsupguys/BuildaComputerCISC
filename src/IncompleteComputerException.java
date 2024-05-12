import javax.swing.*;

public class IncompleteComputerException extends RuntimeException {
    IncompleteComputerException(String message) {
        super(message);
        String partTypesString = String.join(", ", PartInventory.getPartTypes());
        JOptionPane.showMessageDialog(null, "Please add all required parts: " + partTypesString);
    }
}
