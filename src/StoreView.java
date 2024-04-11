import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StoreView extends JFrame {
    private JPanel storePanel;
    private JPanel pickPartPanel;
    private JPanel specsPanel;
    private JPanel buttonsPanel;
    private Border panelBorder;
    private final Color textColor;
    private final Color borderColor;
    private final Color panelColor;
    private JButton[][] partSelectButtons;
    private int WIDTH;
    private int HEIGHT;
    private StoreModel storeModel;
    
    public StoreView(StoreModel storeModel) {
        // initializations
        this.storeModel = storeModel;
        textColor = Color.white;
        borderColor = Color.white;
        panelColor = Color.darkGray;
        WIDTH = 800;
        HEIGHT = 450;
        
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
        
        // buttonsPanel
        buttonsPanel = new JPanel();
        
        
        // pickPartPanel
        pickPartPanel = new JPanel();
        pickPartPanel.setLayout(new BorderLayout());
        pickPartPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        pickPartPanel.setBackground(panelColor);
        pickPartPanel.setBorder(panelBorder);
        // make JLabel, set text and center it
        JLabel pickPartLabel = new JLabel("Select a type of part to buy", SwingConstants.CENTER);
        // centers text, optional
//        pickPartLabel.setVerticalAlignment(SwingConstants.CENTER);
        pickPartLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        pickPartLabel.setForeground(textColor);
        pickPartPanel.add(buttonsPanel, BorderLayout.CENTER);
        pickPartPanel.add(pickPartLabel, BorderLayout.NORTH);
        
        // specsPanel
        specsPanel = new JPanel();
        storePanel.setLayout(new BorderLayout());
        specsPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
        specsPanel.setBorder(panelBorder);
        specsPanel.setBackground(panelColor);
        
        // add panels to frame
        storePanel.add(pickPartPanel, BorderLayout.WEST);
        storePanel.add(specsPanel, BorderLayout.EAST);
        
        add(storePanel);
        setVisible(true);
        
    }
    
    
    public void update() {
    
    }
    
}
