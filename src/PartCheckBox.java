import javax.swing.*;
/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 * this class serves to make the process of making checkboxes in the home panel easier. A user will have a selection of
 * parts represented by checkboxes. The user then clicks on the checkbox to move it into the computer they are building.
 */

// PartCheckBox is a JCheckBox
public class PartCheckBox extends JCheckBox {
    
    // has-a Part
    private Part part;
    
    /**
     * Constructor for a PartCheckBox
     * @param part
     */
    public PartCheckBox(Part part) {
        super();
        this.part = part;
    }
    
    /**
     * returns the part that the checkbox is associated with
     * @return part
     */
    public Part getPart() {
        return part;
    }
    
    public String getPartName() {
        return part.getName();
    }
    
    /**
     * set the part that the checkbox is associated with
     * @param part
     */
    public void setPart(Part part) {
        this.part = part;
    }
}
