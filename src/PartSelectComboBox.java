import javax.swing.*;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * for easy setup of comboboxes within the Storeview
 */

// PartSelectComboBox is a JComboBox
public class PartSelectComboBox extends JComboBox {
	// has a part type
    String partType;
    
    /**
     * get the type of part the combo box will be used for
     * @return
     */
    public String getPartType() {
        return partType;
    }
    
    /**
     * set the type of part the combo box will be used for
     * @param partType
     */
    public void setPartType(String partType) {
        this.partType = partType;
    }
    
    /**
     * check if a part is in the combo box
     * @param part
     */
    public void containsPart(Part part) {
//        currentPart
//        for (int i = 0; i < getItemCount(); i++) {
//
//        }
    }
    
}

