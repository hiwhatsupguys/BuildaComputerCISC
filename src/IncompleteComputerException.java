import javax.swing.*;

/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * This class is essential for exception handling in the event a User tries to checkout with an incomplete computer.
 */

public class IncompleteComputerException extends RuntimeException {
    IncompleteComputerException(String message, Computer computer) {
        super(message);
    }
}
