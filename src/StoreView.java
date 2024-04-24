import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

public class StoreView extends JFrame {
    private JPanel storePanel;
    private JPanel pickPartTypePanel;
    private JPanel specsPanel;
    private JPanel partSelectButtonsPanel;
    private JPanel buySellButtonsPanel;
    private JPanel partInfoPanel;
    private Border panelBorder;
    private final Color textColor;
    private final Color borderColor;
    private final Color panelColor;
    private JButton[] partSelectButtons;
    private int WIDTH;
    private int HEIGHT;
    private StoreModel storeModel;
    private Controller controller;
    private PartInventory partInventory;
    private String[] partTypes;
    private int numberOfPartTypes;
    private JComboBox partSelectComboBox;
    private JButton buyButton;
    private JButton sellButton;
    private JLabel partInfo;
    
    public StoreView(StoreModel storeModel) {
        // initializations
        this.storeModel = storeModel;
        textColor = Color.white;
        borderColor = Color.white;
        panelColor = Color.darkGray;
        WIDTH = 800;
        HEIGHT = 450;
        partInventory = storeModel.getPartInventory();
        controller = new Controller(storeModel, this);
        partTypes = partInventory.getPartTypes();
        numberOfPartTypes = partInventory.getNumberOfPartTypes();
        partSelectButtons = new JButton[numberOfPartTypes];
        partSelectComboBox = new JComboBox();
        
        setTitle("Build a Computer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        setResizable(false);
        // puts in center of screen
        setLocationRelativeTo(null);
        
        // border (color and thickness)
        panelBorder = BorderFactory.createLineBorder(borderColor, 4);
        
        // storePanel
        storePanel = new JPanel();
        storePanel.setLayout(new BorderLayout());
        storePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        storePanel.setBackground(Color.white);
        
        // partSelectButtons
        
        // @TODO buttonsPanel
        partSelectButtonsPanel = new JPanel();
        // testing
        partSelectButtonsPanel.setBackground(Color.green);
        
        // add the buttons with part types to the button panel
        partSelectButtonsPanel.setLayout(new GridLayout());
//        buttonsPanel.setPreferredSize(new Dimension(100, 100));
//        System.out.println(Arrays.toString(partInventory.getPartTypes()));
        for (int i = 0; i < numberOfPartTypes; i++) {
            JButton button = new JButton(partTypes[i]);
            button.addActionListener(controller);
            partSelectButtonsPanel.add(button);
            partSelectButtons[i] = button;
        }

//        for (String partType : partInventory.getPartTypes()) {
//            JButton button = new JButton(partType);
//            button.addActionListener(controller);
//            buttonsPanel.add(button);
//        }
        
        // pickPartPanel
        pickPartTypePanel = new JPanel();
        pickPartTypePanel.setLayout(new BorderLayout());
        pickPartTypePanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        pickPartTypePanel.setBackground(panelColor);
        pickPartTypePanel.setBorder(panelBorder);
        // make JLabel, set text and center it
        JLabel pickPartLabel = new JLabel("Select a type of part to buy", SwingConstants.CENTER);
        // centers text, optional
//        pickPartLabel.setVerticalAlignment(SwingConstants.CENTER);
        pickPartLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        pickPartLabel.setForeground(textColor);
        pickPartTypePanel.add(pickPartLabel, BorderLayout.NORTH);
        pickPartTypePanel.add(partSelectButtonsPanel, BorderLayout.CENTER);
        
        // specsPanel
        specsPanel = new JPanel();
        specsPanel.setLayout(new BorderLayout());
        specsPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        specsPanel.setBorder(panelBorder);
        specsPanel.setBackground(panelColor);
        
        // part info
        partInfo = new JLabel();
        partInfoPanel = new JPanel();
        partInfoPanel.setLayout(null);
        partInfoPanel.add(partInfo);
        
        // buy/sell buttons
        buyButton = new JButton("Buy");
        buyButton.addActionListener(controller);
        sellButton = new JButton("Sell");
        sellButton.addActionListener(controller);
//        buyButton.setVisible(false);
//        sellButton.setVisible(false);
        
        // add panels to frame
        storePanel.add(pickPartTypePanel, BorderLayout.WEST);
        storePanel.add(specsPanel, BorderLayout.EAST);
        
        add(storePanel);
        setVisible(true);
        
    }
    
    public void showSpecsPanel(String partType) {
        // removes all components from specsPanel
        specsPanel.removeAll();
        Part[] partsOfType = partInventory.getPartsOfType(partType);
        String[] namesOfParts = new String[partsOfType.length];
        
        buySellButtonsPanel = new JPanel();
        buySellButtonsPanel.setLayout(new FlowLayout());
        // add buttons to panel
        buySellButtonsPanel.add(buyButton);
        buySellButtonsPanel.add(sellButton);
        
        // store the names of the parts of specific type to the namesOfParts variable
        for (int i = 0; i < partsOfType.length; i++) {
            namesOfParts[i] = partsOfType[i].getName();
        }
        
        partSelectComboBox = new JComboBox(namesOfParts);
//        partSelectComboBox.setPreferredSize(new Dimension(200, 50));
        
        
        specsPanel.add(partSelectComboBox, BorderLayout.NORTH);
        specsPanel.add(buySellButtonsPanel, BorderLayout.CENTER);
        // need to call this method to show new components on already visible panel, see this link:
        // https://stackoverflow.com/questions/26853598/jpanel-not-showing-components
        specsPanel.revalidate();
//        specsPanel.repaint();
        specsPanel.setVisible(true);
    }
    
    public JButton[] getPartSelectButtons() {
        return partSelectButtons;
        //
    }
    public JButton getBuyButton() {
        return buyButton;
    }
    public JButton getSellButton() {
        return sellButton;
    }


//    public void update() {
//
//    }
    
}
