import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

// controller is an Action Listener
public class Controller implements ActionListener {
    // the controller...
    // has a model
    private StoreModel model;
    // has a view
    private StoreView view;
    private JButton[] partSelectButtons;
    
    /**
     * Constructor for Controller class
     *
     * @param model
     * @param view
     */
    public Controller(StoreModel model, StoreView view) {
        this.model = model;
        this.view = view;
        // set partSelectButtons to the view's buttons
    }
    
    /**
     * Event listener
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        partSelectButtons = view.getPartSelectButtons();
        // loop over all part select buttons
//        System.out.println(partSelectButtons);
        for (int i = 0; i < partSelectButtons.length; i++) {
            JButton currentButton = partSelectButtons[i];
            if (e.getSource() == currentButton) {
                String partType = currentButton.getText();
                view.showSpecsPanel(partType);
//                System.out.println(partType);
            }
        }
    }
}