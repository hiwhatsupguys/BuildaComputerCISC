import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 */

// Store view is a JFrame
public class StoreView extends JFrame {
    // A StoreView has...
    private JPanel mainPanel;
    // a JPanel currentPanel
    private JPanel currentPanel;
    // a JPanel storePanel
    private JPanel storePanel;
    // a JPanel homePanel
    private JPanel homePanel;
    // a JPanel pickPartTypePanel
    private JPanel pickPartTypePanel;
    // a JPanel specsPanel
    private JPanel specsPanel;
    // a JPanel partSelectButtonsPanel
    private JPanel partSelectButtonsPanel;
    // a JPanel buySellButtonsPanel
    private JPanel buySellButtonsPanel;
    // a JPanel partInfoPanel
    private JPanel partInfoPanel;
    // a JPanel topPanel
    private JPanel topPanel;
    // a Border panelBorder
    private Border panelBorder;
    // a Color textColor that is final
    private final Color textColor;
    // a Color borderColor that is final
    private final Color borderColor;
    // a Color panelColor that is final
    private final Color panelColor;
    // a Array of JButons partSelectButtons
    private JButton[] partSelectButtons;
    // a Width
    private int WIDTH;
    // a Height
    private int HEIGHT;
    // a StoreModel storeModel
    private StoreModel storeModel;
    // a Controller controller
    private Controller controller;
    // a PartInventory partInventory
    private PartInventory partInventory;
    // an Array of strings partTypes
    private String[] partTypes;
    // a number of part types
    private int numberOfPartTypes;
    // a JComboBox partSelectComboBox
    private JComboBox partSelectComboBox;
    // a JButton buyButton (for buying things in the store)
    private JButton buyButton;
    // a JButton sellButton (for selling things to the store/returning items that the user may not want)
    private JButton sellButton;
    // a JButton storeTabButton
    private JButton storeButton;
    // a JButton homeTabButton
    private JButton homeButton;
    // a JLable partInfoLable
    private JLabel partInfoLabel;
    private JLabel balanceLabel;
    // a Part currentPart
    private Part currentPart;
    private String currentPartType;
    private int storePanelHeight;
    private double balance;
    private final DecimalFormat balanceFormat = new DecimalFormat(".00");
    private JPanel topButtonsPanel;
    
    public StoreView(StoreModel storeModel) {
        // this is to make it look the same on mac and windows
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        // border (color and thickness)
        panelBorder = BorderFactory.createLineBorder(borderColor, 4);
        
        setTitle("Build a Computer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        setResizable(false);
        // puts in center of screen
        setLocationRelativeTo(null);
        
        // mainPanel (has both store, home, and top panels)
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        setupStorePanel();
        setupTopPanel();
        setupHomePanel();
        
        // add panels to storePanel
        storePanel.add(pickPartTypePanel, BorderLayout.CENTER);
        storePanel.add(specsPanel, BorderLayout.EAST);
        
        // add panels to homePanel
        
        // add panels to mainPanel
        mainPanel.add(storePanel, BorderLayout.CENTER);
//        mainPanel.add(homePanel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        add(mainPanel);
        setVisible(true);
        
        // currentPanel
        currentPanel = storePanel;
        
        updateTopPanel();
        
    }
    
    
    private void setupStorePanel() {
        
        // storePanel
        storePanel = new JPanel();
        storePanel.setLayout(new BorderLayout());
        storePanelHeight = (int) (HEIGHT * 0.92);
        storePanel.setPreferredSize(new Dimension(WIDTH, storePanelHeight));
//        storePanel.setBackground(Color.white);
        
        // partSelectButtons
        partSelectButtonsPanel = new JPanel();
        // testing
        partSelectButtonsPanel.setBackground(Color.green);
        
        // add the buttons with part types to the button panel
        GridLayout gridLayout = new GridLayout();
        // we might want to set rows and columns
//        gridLayout.setRows(3);
//        gridLayout.setColumns(3);
        int gap = WIDTH / 100;
        gridLayout.setHgap(gap);
        gridLayout.setVgap(gap);
        partSelectButtonsPanel.setLayout(new FlowLayout());
//        buttonsPanel.setPreferredSize(new Dimension(100, 100));
//        System.out.println(Arrays.toString(partInventory.getPartTypes()));
        for (int i = 0; i < numberOfPartTypes; i++) {
            JButton button = new JButton(partTypes[i]);
            button.addActionListener(controller);
            button.setPreferredSize(new Dimension(100, 100));
            partSelectButtonsPanel.add(button);
            partSelectButtons[i] = button;
        }
        
        // pickPartPanel
        pickPartTypePanel = new JPanel();
        pickPartTypePanel.setLayout(new BorderLayout());
        pickPartTypePanel.setPreferredSize(new Dimension(WIDTH / 2, storePanelHeight));
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
        specsPanel.setPreferredSize(new Dimension(WIDTH / 2, storePanelHeight));
        specsPanel.setBorder(panelBorder);
        specsPanel.setBackground(panelColor);
        
        // part info
        partInfoLabel = new JLabel("", SwingConstants.LEFT);
        partInfoLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        partInfoPanel = new JPanel();
        FlowLayout partInfoPanelLayout = new FlowLayout();
        partInfoPanelLayout.setAlignment(FlowLayout.LEFT);
        partInfoPanel.setLayout(partInfoPanelLayout);
//        partInfoPanel.setOpaque(false);
        partInfoPanel.add(partInfoLabel);
        
        // buy/sell buttons
        buyButton = new JButton("Buy");
        buyButton.addActionListener(controller);
        sellButton = new JButton("Sell");
        sellButton.addActionListener(controller);
        buySellButtonsPanel = new JPanel();
        buySellButtonsPanel.setLayout(new FlowLayout());
        // makes it transparent
        buySellButtonsPanel.setOpaque(false);
        // add buttons to panel
        buySellButtonsPanel.add(buyButton);
        buySellButtonsPanel.add(sellButton);
    }
    
    private void setupTopPanel() {
        int topPanelHeight = HEIGHT - storePanelHeight;
        
        // topButtonsPanel
        topButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topButtonsPanel.setPreferredSize(new Dimension(WIDTH / 2, topPanelHeight));
        storeButton = new JButton("Store");
        homeButton = new JButton("Home");
        storeButton.addActionListener(controller);
        homeButton.addActionListener(controller);
        topButtonsPanel.add(storeButton);
        topButtonsPanel.add(homeButton);
        
        // topPanel
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(WIDTH, topPanelHeight));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(topButtonsPanel, BorderLayout.WEST);
        balanceLabel = new JLabel("");
        topPanel.add(balanceLabel, BorderLayout.EAST);
    }
    
    private void setupHomePanel() {
        homePanel = new JPanel();
    }
    
    public void update() {
        updateSpecsPanel();
        updateTopPanel();
        updateHomePanel();
    }
    
    private void updateSpecsPanel() {
        // removes all components from specsPanel
        specsPanel.removeAll();
        Part[] partsOfType = partInventory.getPartsOfType(currentPartType);
        partSelectComboBox = new JComboBox(partsOfType);
        currentPart = (Part) partSelectComboBox.getSelectedItem();
        String info = currentPart.getInfo();
        info = "<html>" + info + "</html>";
        info = info.replace(",\n", "<br/>");
        partInfoLabel.setText(info);
        
        specsPanel.add(partSelectComboBox, BorderLayout.NORTH);
        specsPanel.add(buySellButtonsPanel, BorderLayout.SOUTH);
        specsPanel.add(partInfoPanel, BorderLayout.CENTER);
        
        // need to call this method to show new components on already visible panel, see this link:
        // https://stackoverflow.com/questions/26853598/jpanel-not-showing-components
        specsPanel.revalidate();
//        specsPanel.repaint();
    }
    
    
    private void updateTopPanel() {
        // UPDATE BALANCE
        balance = storeModel.getUser().getBalance();
        String balanceString = balanceFormat.format(balance);
        balanceLabel.setText("Balance: " + balanceString + "   ");
        topPanel.revalidate();
    }
    
    private void updateHomePanel() {
    }
    
    /**
     * switches the current panel (storePanel or homePanel)
     *
     * @param newPanel
     */
    public void setCurrentPanel(JPanel newPanel) {
        // don't do anything if the newPanel is already the currentPanel
        if (newPanel == currentPanel) return;
        currentPanel = newPanel;
        currentPanel.setVisible(false);
        mainPanel.remove(currentPanel);
//        currentPanel.setVisible(false);
//
//        currentPanel = newPanel;
//        currentPanel.setVisible(true);
    }
    
    public void setCurrentPartType(String currentPartType) {
        this.currentPartType = currentPartType;
    }
    
    public String getCurrentPartType() {
        return currentPartType;
    }
    
    public Part getCurrentPart() {
        return currentPart;
    }
    
    public JPanel getStorePanel() {
        return storePanel;
    }
    
    public JPanel getHomePanel() {
        return homePanel;
    }
    
    public JPanel getCurrentPanel() {
        return currentPanel;
    }
    
    
    public JButton[] getPartSelectButtons() {
        return partSelectButtons;
    }
    
    public JButton getBuyButton() {
        return buyButton;
    }
    
    public JButton getSellButton() {
        return sellButton;
    }
    
    public JButton getStoreButton() {
        return storeButton;
    }
    
    public JButton getHomeButton() {
        return homeButton;
    }
    
    
}
