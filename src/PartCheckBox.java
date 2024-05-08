import javax.swing.*;
/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 *
 */

// PartCheckBox is a JCheckBox
public class PartCheckBox extends JCheckBox {
    
    // has-a Part
    private Part part;
    
    //
    public PartCheckBox(Part part) {
        super();
        this.part = part;
    }
    
    public Part getPart() {
        return part;
    }
    
    public void setPart(Part part) {
        this.part = part;
    }
}
