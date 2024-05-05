import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
   The Controller class coordinates between the end user, the model, and various other portions of our program.
 */

// controller is an Action Listener
public class Controller implements ActionListener {
    // Controller...
    // has a model
    private StoreModel model;
    // has a view
    private StoreView view;
    // has an array of partSelecteButtons of JButton type
    private JButton[] partSelectButtons;
    // has a buyButton of JButton type
    private JButton buyButton;
    // has a sell button of JButton type
    private JButton sellButton;
    // has a store button of JButton type
    private JButton storeButton;
    // has a home button of JButton type
    private JButton homeButton;
    // has a 
    private Part currentPart;
    // has an ArrayList of JCheckBoxes named checkBoxes
    private ArrayList<JCheckBox> checkBoxes;
    // has a user
    private User user;
    
    
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
        buyButton = view.getBuyButton();
        sellButton = view.getSellButton();
        storeButton = view.getStoreButton();
        homeButton = view.getHomeButton();
        currentPart = view.getCurrentPart();
        user = model.getUser();
//        checkBoxes = view.getCheckBoxes();
        // loop over all part select buttons
        for (int i = 0; i < partSelectButtons.length; i++) {
            JButton currentButton = partSelectButtons[i];
            // if the source comes from the button that says "GPU, CPU, etc."
            if (e.getSource() == currentButton) {
                String partType = currentButton.getText();
                // show the corresponding part types in the specs panel
                view.setCurrentPartType(partType);
            }
        }
        // check if from buyButton
        if (e.getSource() == buyButton) {
            view.addCheckBox(currentPart);
//            view.addCheckBox(new JCheckBox(currentPart.toString()));
            model.buy(currentPart);
            model.getPartInventory().printDebugInfo();
        }
        // check if from sellButton
        if (e.getSource() == sellButton) {
            System.out.println(currentPart);
            model.sell(currentPart);
            if (user.getInventory().getPartCount(currentPart) < 1) {
                view.removeCheckBox(currentPart);
            }
            model.getPartInventory().printDebugInfo();
        }
        // check if from storeButton
        if (e.getSource() == storeButton) {
            view.setCurrentPanel(view.getStorePanel());
        }
        // check if from homeButton
        if (e.getSource() == homeButton) {
            view.setCurrentPanel(view.getHomePanel());
            System.out.println(model.getUser().getInventory().getAllOwnedParts());
        }
        // CHECKBOXES
//        for (JCheckBox checkBox : checkBoxes) {
//            if (e.getSource() == checkBox) {
//            }
//        }
        
        view.update();
    }
    
}