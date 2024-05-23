import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * The Controller class coordinates between the end user, the model, and various other portions of our program.
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
    private ArrayList<PartCheckBox> checkBoxes;
    // has a user
    private User user;
    // has a computer
    private Computer computer;
    
    
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
     * This action listener is deprecated as of week 6 of the project.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
//        partSelect
//        buyButton = view.getBuyButton();
//        sellButton = view.getSellButton();
//        storeButton = view.getStoreButton();
//        homeButton = view.getHomeButton();
//        currentPart = view.getCurrentPart();
//        user = model.getUser();
//        checkBoxes = view.getCheckBoxes();
//        computer = user.getComputer();
        // loop over all part select buttons
//        for (int i = 0; i < partSelectButtons.length; i++) {
//            JButton currentButton = partSelectButtons[i];
//            // if the source comes from the button that says "GPU, CPU, etc."
//            if (e.getSource() == currentButton) {
//                String partType = currentButton.getText();
//                // show the corresponding part types in the specs panel
//                view.setCurrentPartType(partType);
//            }
//        }
//        // check if from buyButton
//        if (e.getSource() == buyButton) {
//            view.addCheckBox(currentPart);
////            view.addCheckBox(new JCheckBox(currentPart.toString()));
//            model.buy(currentPart);
//            user.getInventory().printDebugInfo();
//        }
//        // check if from sellButton
//        if (e.getSource() == sellButton) {
//            System.out.println(currentPart);
//            model.sell(currentPart);
//            if (user.getInventory().getPartCount(currentPart) < 1) {
//                view.removeCheckBox(currentPart);
//            }
//            user.getInventory().printDebugInfo();
//        }
//        // check if from storeButton
//        if (e.getSource() == storeButton) {
//            view.setCurrentPanel(view.getStorePanel());
//        }
//        // check if from homeButton
//        if (e.getSource() == homeButton) {
//            view.setCurrentPanel(view.getHomePanel());
//        }
//        // CHECKBOXES (NULL)
//        for (PartCheckBox checkBox : checkBoxes) {
//            // NULL for some reason...
//            Part part = checkBox.getPart();
//            if (e.getSource() == checkBox) {
//                if (!checkBox.isSelected()) {
//                    // if checkbox IS selected (deselect it)
//                    // remove part from computer
//                    computer.removePart(part);
//                } else {
//                    // if checkbox IS NOT selected (then select it)
//                    // only add part if computer has it
//                    if (!computer.hasPart(part)) {
//                        computer.addPart(part);
//                    } else {
//                        // if computer already has the part, then don't add it
//                    }
//                }
//            }
//        }
        
//        view.update();
    }
    
}