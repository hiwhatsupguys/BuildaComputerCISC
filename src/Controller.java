import javax.net.ssl.KeyStoreBuilderParameters;
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
        // loop over all part select buttons
        for (int i = 0; i < partSelectButtons.length; i++) {
            JButton currentButton = partSelectButtons[i];
            // if the source comes from the button that says "GPU, CPU, etc."
            if (e.getSource() == currentButton) {
                String partType = currentButton.getText();
                // show the corresponding part types in the specs panel
                view.showSpecsPanel(partType);
            }
        }
        // check if from buyButton
        if (e.getSource() == buyButton) {
            System.out.println("buy!");
        }
        // check if from sellButton
        if (e.getSource() == sellButton) {
            System.out.println("sell!");
        }
        // check if from storeButton
        if (e.getSource() == storeButton) {
            view.setCurrentPanel(view.getStorePanel());
        }
        // check if from homeButton
        if (e.getSource() == homeButton) {
            System.out.println("sell!");
        }
    }
}