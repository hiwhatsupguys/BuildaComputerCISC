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
    private JButton buyButton;
    private JButton sellButton;
    private JButton storeButton;
    private JButton homeButton;
    private Part currentPart;
    
    
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
            model.buy(currentPart);
            System.out.println(model.getUser().getBalance());
        }
        // check if from sellButton
        if (e.getSource() == sellButton) {
            model.sell(currentPart);
            System.out.println(model.getUser().getBalance());
        }
        // check if from storeButton
        if (e.getSource() == storeButton) {
            view.setCurrentPanel(view.getStorePanel());
        }
        // check if from homeButton
        if (e.getSource() == homeButton) {
            view.setCurrentPanel(view.getHomePanel());
        }
        
        // tests
        model.getPartInventory().printDebugInfo();
        
        
        view.update();
    }
}