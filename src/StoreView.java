import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 *         <p>
 *         <p>
 *         Additional Resources:
 *         <p>
 *         https://stackoverflow.com/questions/26853598/jpanel-not-showing-components
 *         <p>
 *         Class Responsibilities:
 *         The StoreView Class is responsible for displaying all the information
 *         a user needs to buy parts and build their computer.
 */

// Store view is a JFrame
public class StoreView extends JFrame
{
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
	// a JButton sellButton (for selling things to the store/returning items
	// that the user may not want)
	private JButton sellButton;
	// a JButton storeTabButton
	private JButton storeButton;
	// a JButton homeTabButton
	private JButton homeButton;
	// a JLable partInfoLable
	private JLabel partInfoLabel;
	// a JTextArea to display information on parts
	private JTextArea partInfoTextArea;
	// has a JLable to display a User's balance
	private JLabel balanceLabel;
	// a Part currentPart
	private Part currentPart;
	// a String to represent the current part type
	private String currentPartType;
	// a height
	private int storePanelHeight;
	// a balance
	private double balance;
	// a format for the display of the blance
	private final DecimalFormat balanceFormat = new DecimalFormat(".00");
	// a JPanel for the top panel
	private JPanel topButtonsPanel;
	// a JPanel for a computer parts panel
	private JPanel computerPartsPanel;
	// a JPanel for a user parts panel
	private JPanel userPartsPanel;
	// an array list of PartsChecksBoxes for checkboxes
	private ArrayList<PartCheckBox> checkBoxes;
	// private JLabel currentComputerPartsLabel;
	// a JTextAtrea for the current computer parts displayed
	private JTextArea currentComputerPartsTextArea;
    // a checkout button
    private JButton checkoutButton;

	/**
	 * constructor for a store view
	 *
	 * @param storeModel
	 */
	public StoreView(StoreModel storeModel)
	{
		// this is to make it look the same on mac and windows
		try
		{
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e)
		{
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
		partTypes = PartInventory.getPartTypes().toArray(new String[0]);
		numberOfPartTypes = partInventory.getNumberOfPartTypes();
		partSelectButtons = new JButton[numberOfPartTypes];
		partSelectComboBox = new JComboBox();
		// border (color and thickness)
		panelBorder = BorderFactory.createLineBorder(borderColor, 4);

		setTitle("Build a Computer");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(new BorderLayout());
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
		mainPanel.add(topPanel, BorderLayout.NORTH);
		add(mainPanel);
		setVisible(true);

		// currentPanel
		// currentPanel = storePanel;
		setCurrentPanel(storePanel);

		updateTopPanel();

	}

	/**
	 *
	 */
	private void setupStorePanel()
	{

		// storePanel
		storePanel = new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanelHeight = (int) (HEIGHT * 0.92);
		storePanel.setPreferredSize(new Dimension(WIDTH, storePanelHeight));
		// storePanel.setBackground(Color.white);

		// checkboxes
		checkBoxes = new ArrayList<>();

		// partSelectButtons
		partSelectButtonsPanel = new JPanel();
		// testing
		partSelectButtonsPanel.setBackground(Color.green);

		// add the buttons with part types to the button panel
		GridLayout gridLayout = new GridLayout();
		// we might want to set rows and columns
		gridLayout.setRows(3);
		// gridLayout.setColumns(3);
		int gap = WIDTH / 100;
		gridLayout.setHgap(gap);
		gridLayout.setVgap(gap);
		partSelectButtonsPanel.setLayout(gridLayout);
		// buttonsPanel.setPreferredSize(new Dimension(100, 100));
		for (int i = 0; i < numberOfPartTypes; i++)
		{
			String partType = partTypes[i];
			JButton button = new JButton(partType);
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					// if the source comes from the button that says "GPU, CPU,
					// etc."
					// show the corresponding part types in the specs panel
					setCurrentPartType(partType);
					updateComboBox();
				}
			});
			button.setPreferredSize(new Dimension(100, 100));
			button.setFont(new Font("Verdana", Font.PLAIN, 20));
			partSelectButtonsPanel.add(button);
			partSelectButtons[i] = button;
		}

		// pickPartPanel
		pickPartTypePanel = new JPanel();
		pickPartTypePanel.setLayout(new BorderLayout());
		pickPartTypePanel
				.setPreferredSize(new Dimension(WIDTH / 2, storePanelHeight));
		pickPartTypePanel.setBackground(panelColor);
		pickPartTypePanel.setBorder(panelBorder);
		// make JLabel, set text and center it
		JLabel pickPartLabel = new JLabel("Select a type of part to buy",
				SwingConstants.CENTER);
		// centers text, optional
		// pickPartLabel.setVerticalAlignment(SwingConstants.CENTER);
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
		partInfoTextArea = new JTextArea();
		partInfoTextArea.setFont(new Font("Verdana", Font.PLAIN, 25));
		partInfoTextArea.setForeground(Color.white);
		partInfoTextArea.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
		partInfoTextArea.setEditable(false);
		partInfoTextArea.setOpaque(false);
		partInfoTextArea.setLineWrap(true);
		partInfoTextArea.setWrapStyleWord(true);
		partInfoTextArea.setFocusable(false);

		// partInfoLabel = new JLabel("", SwingConstants.LEFT);
		// partInfoLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
		partInfoPanel = new JPanel();
		FlowLayout partInfoPanelLayout = new FlowLayout();
		partInfoPanelLayout.setAlignment(FlowLayout.LEFT);
		partInfoPanel.setLayout(partInfoPanelLayout);
		partInfoPanel.setOpaque(false);
		// partInfoPanel.add(partInfoLabel);
		partInfoPanel.add(partInfoTextArea);

		// buy/sell buttons
		buyButton = new JButton("Buy");
		// testing making listeners for buy buttons
		buyButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				addCheckBox(currentPart);
				storeModel.buy(currentPart);
				updateTopPanel();
				updateHomePanel();
				// update();
			}
		});

		sellButton = new JButton("Sell");
		sellButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				storeModel.sell(currentPart);
				if (storeModel.getUser().getInventory()
						.getPartCount(currentPart) < 1)
				{
					removeCheckBox(currentPart);
				}
				updateHomePanel();
				updateTopPanel();
				// storeModel.getUser().getInventory().printDebugInfo();
				// update();
			}
		});
		buySellButtonsPanel = new JPanel();
		buySellButtonsPanel.setLayout(new FlowLayout());
		// makes it transparent
		buySellButtonsPanel.setOpaque(false);
		// add buttons to panel
		buySellButtonsPanel.add(buyButton);
		buySellButtonsPanel.add(sellButton);

		partSelectComboBox = new JComboBox();
		partSelectComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				currentPart = (Part) partSelectComboBox.getSelectedItem();
				if (currentPart != null)
				{
					String info = currentPart.getInfo();
					// info = "<html>" + info + "</html>";
					// info = info.replace(",\n", "<br/>");
					// partInfoLabel.setText(info);
					partInfoTextArea.setText(info);
				}
				specsPanel.revalidate();
				System.out.println(currentPart);
				// updateSpecsPanel();
			}
		});

		specsPanel.add(partSelectComboBox, BorderLayout.NORTH);
		specsPanel.add(buySellButtonsPanel, BorderLayout.SOUTH);
		specsPanel.add(partInfoPanel, BorderLayout.CENTER);
	}

	/**
	 * The setupTopPanel method creates the top panel and adds it to the top of
	 * the BorderLayout in the store view
	 */
	private void setupTopPanel()
	{
		int topPanelHeight = HEIGHT - storePanelHeight;

		// topButtonsPanel
		topButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topButtonsPanel
				.setPreferredSize(new Dimension(WIDTH / 2, topPanelHeight));
		storeButton = new JButton("Store");
		homeButton = new JButton("Home");
		checkoutButton = new JButton("Checkout");
		storeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setCurrentPanel(getStorePanel());
				updateComboBox();
			}
		});
		homeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setCurrentPanel(getHomePanel());
			}
		});
		checkoutButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) throws IncompleteComputerException
			{
				Computer computer = storeModel.getUser().getComputer();
				// if the computer is not full
				if (!computer.hasRequiredParts()) {
					// throw exception
					String partTypesString = String.join(", ", partTypes);
					throw new IncompleteComputerException("Computer is not complete. Add all required parts to computer: " +
                            partTypesString);
				}
				String info = "";
				info += "Computer:\n";
				info += computer.toString();
				info += "Exit?";
				int response = JOptionPane.showConfirmDialog(null, info, "", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (response == JOptionPane.NO_OPTION) {
				
				}
			}
		});
		topButtonsPanel.add(storeButton);
		topButtonsPanel.add(homeButton);
		topButtonsPanel.add(checkoutButton);
		

		// topPanel
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(WIDTH, topPanelHeight));
		topPanel.setLayout(new BorderLayout());
		topPanel.add(topButtonsPanel, BorderLayout.WEST);
		balanceLabel = new JLabel("");
		topPanel.add(balanceLabel, BorderLayout.EAST);
	}

	/**
	 * The setupHomePanel method creates a new panel called homePanel, this
	 * panel will
	 * track the list of parts a user has selected thus far as well as what the
	 * user will decided to build their
	 * computer with
	 */
	private void setupHomePanel()
	{
		homePanel = new JPanel(new BorderLayout());

		// currentComputerPartsTextArea setup
		currentComputerPartsTextArea = new JTextArea();
		currentComputerPartsTextArea
				.setFont(new Font("Verdana", Font.PLAIN, 25));
		currentComputerPartsTextArea
				.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
		currentComputerPartsTextArea.setEditable(false);
		currentComputerPartsTextArea.setOpaque(false);
		currentComputerPartsTextArea.setLineWrap(true);
		currentComputerPartsTextArea.setWrapStyleWord(true);
		currentComputerPartsTextArea.setFocusable(false);

		// currentComputerPartsLabel setup
		// currentComputerPartsLabel = new JLabel("", SwingConstants.LEFT);
		// currentComputerPartsLabel.setFont(new Font("Verdana", Font.PLAIN,
		// 25));

		// user's parts on the left
		// user's computer on the right (with the parts that are in the
		// computer)
		computerPartsPanel = new JPanel();
		computerPartsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		computerPartsPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
		computerPartsPanel.setBorder(panelBorder);
		computerPartsPanel.setBackground(Color.cyan);
		// computerPartsPanel.add(currentComputerPartsLabel);
		computerPartsPanel.add(currentComputerPartsTextArea);
		// test
		// currentComputerPartsLabel.setText("test");

		// user panel setup
		userPartsPanel = new JPanel();
		userPartsPanel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT));
		userPartsPanel.setBackground(Color.blue);
		userPartsPanel.setBorder(panelBorder);

		homePanel.add(userPartsPanel, BorderLayout.WEST);
		homePanel.add(computerPartsPanel, BorderLayout.EAST);
	}

	/**
	 * the update method updates the store view in its entirety
	 */
	public void update()
	{
		updateComboBox();
		updateTopPanel();
		updateHomePanel();
	}

	/**
	 * The updateSpecsPanel is updates the specs panel whenever a user is
	 * looking through the store's
	 * selection of parts
	 */
	private void updateComboBox()
	{
		// removes all components from specsPanel
		// specsPanel.removeAll();
		// specsPanel.remove(partSelectComboBox);

		Part[] partsOfType = partInventory.getPartsOfType(currentPartType);
		partSelectComboBox.removeAllItems();
		for (Part part : partsOfType)
		{
			partSelectComboBox.addItem(part);
		}

		currentPart = (Part) partSelectComboBox.getSelectedItem();

		// need to call this method to show new components on already visible
		// panel, see this link:
		// https://stackoverflow.com/questions/26853598/jpanel-not-showing-components
		specsPanel.revalidate();
		// specsPanel.repaint();
	}

	/**
	 * The updateTopPanel method updates a user's balance after a part has been
	 * selected
	 */
	private void updateTopPanel()
	{
		// UPDATE BALANCE
		balance = storeModel.getUser().getBalance();
		String balanceString = balanceFormat.format(balance);
		balanceLabel.setText("Balance: " + balanceString + "   ");
		topPanel.revalidate();
	}

	/**
	 * updates changes in homePanel
	 */
	private void updateHomePanel()
	{

		// check every part in computer, then add them to the JLabel
		Computer computer = storeModel.getUser().getComputer();
		String textToAdd = "";
		ArrayList<String> partStrings = new ArrayList<>();
		for (Part part : computer.getParts())
		{
			String partName = part.getName();
			String partType = part.getType();
			// partStrings.add(partType + ": " + partName + "<br/>");
			partStrings.add(partType + ": " + partName + "\n");
			partStrings.sort(String::compareToIgnoreCase);
		}
		for (String partString : partStrings)
		{
			textToAdd = textToAdd.concat(partString);
		}
		// textToAdd = "<html>" + textToAdd + "</html>";
		// currentComputerPartsLabel.setText(textToAdd);
		currentComputerPartsTextArea.setText(textToAdd);

		// ADDING CHECKBOXES FROM USER INVENTORY!!!
		// CHECK IF THE CHECKBOX IS ALREADY THERE
		homePanel.revalidate();
	}

	// public void addPartToComputerPanel(Part part) {
	// }

	/**
	 * switches the current panel (storePanel or homePanel)
	 *
	 * @param newPanel
	 */
	public void setCurrentPanel(JPanel newPanel)
	{
		// don't do anything if the newPanel is already the currentPanel
		if (newPanel == currentPanel) return;
		if (currentPanel == null) currentPanel = newPanel;

		currentPanel.setVisible(false);
		mainPanel.remove(currentPanel);
		currentPanel = newPanel;
		currentPanel.setVisible(true);
		mainPanel.add(currentPanel, BorderLayout.CENTER);
	}

	/**
	 * @return checkBoxes
	 */
	public ArrayList<PartCheckBox> getCheckBoxes()
	{
		return checkBoxes;
	}

	/**
	 * @param currentPartType
	 */
	public void setCurrentPartType(String currentPartType)
	{
		this.currentPartType = currentPartType;
	}

	/**
	 * @return currentPartType
	 */
	public String getCurrentPartType()
	{
		return currentPartType;
	}

	/**
	 * @return currentPart
	 */
	public Part getCurrentPart()
	{
		return currentPart;
	}

	/**
	 * @return storePanel
	 */
	public JPanel getStorePanel()
	{
		return storePanel;
	}

	/**
	 * @return homePanel
	 */
	public JPanel getHomePanel()
	{
		return homePanel;
	}

	/**
	 * @return currentPanel
	 */
	public JPanel getCurrentPanel()
	{
		return currentPanel;
	}

	/**
	 * @return partSelectedButtons
	 */
	public JButton[] getPartSelectButtons()
	{
		return partSelectButtons;
	}
	/**
	 * returns the buy button
	 * @return buyButton
	 */
	public JButton getBuyButton()
	{
		return buyButton;
	}
	/**
	 * returns the sell button
	 * @return sellButton
	 */
	public JButton getSellButton()
	{
		return sellButton;
	}
	/**
	 * returns the store button
	 * @return storeButton
	 */
	public JButton getStoreButton()
	{
		return storeButton;
	}
	/**
	 * returns the home button
	 * @return homeButton
	 */
	public JButton getHomeButton()
	{
		return homeButton;
	}

	/**
	 * The addCheckBox method adds a checkbox to the home panel based off
	 * of the user's list of selected parts
	 *
	 * @param partToAdd
	 */
	public void addCheckBox(Part partToAdd)
	{
		String textToAdd = partToAdd.toString();
		// checks if the checkbox is already there
		for (PartCheckBox checkBox1 : checkBoxes)
		{
			// if the checkbox is there, then don't do anything
			if (checkBox1.getText().equals(textToAdd))
			{
				return;
			}
		}
		// add the checkbox to the panel
		PartCheckBox checkBoxToAdd = new PartCheckBox(partToAdd);
		checkBoxToAdd.setText(textToAdd);
		checkBoxToAdd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Part part = checkBoxToAdd.getPart();
				Computer computer = storeModel.getUser().getComputer();
				if (e.getSource() == checkBoxToAdd)
				{
					if (!checkBoxToAdd.isSelected())
					{
						// if checkbox IS selected (deselect it)
						// remove part from computer
						computer.removePart(part);
					}
					else
					{
						// if checkbox IS NOT selected (then select it)
						// only add part if computer has it
						if (!computer.hasPart(part))
						{
							computer.addPart(part);
						}
						else
						{
							// if computer already has the part, then don't add
							// it
						}
					}
				}
				updateHomePanel();
			}
		});
		userPartsPanel.add(checkBoxToAdd);
		checkBoxes.add(checkBoxToAdd);
	}

	/**
	 * The removeCheckBox method removes a checkbox from the home panel in the
	 * event a user no longer wants the part they have selected
	 *
	 * @param partToRemove
	 */
	public void removeCheckBox(Part partToRemove)
	{
		String textToRemove = partToRemove.toString();
		PartCheckBox checkBoxToRemove = null;
		for (PartCheckBox checkBox1 : checkBoxes)
		{
			if (checkBox1.getText().equals(textToRemove))
			{
				checkBoxToRemove = checkBox1;
			}
		}
		if (checkBoxToRemove != null)
		{
			userPartsPanel.remove(checkBoxToRemove);
			checkBoxes.remove(checkBoxToRemove);
		}
	}

	// for testing
	// public void addCheckBox(JCheckBox checkBox) {
	// // checks if the checkbox is already there
	// for (JCheckBox checkBox1 : checkBoxes) {
	// // if the checkbox is there, then don't do anything
	// if (checkBox1.getText().equals(currentPart.toString())) return;
	// }
	// // add the checkbox to the panel
	// checkBox.addActionListener(controller);
	// userPartsPanel.add(checkBox);
	// checkBoxes.add(checkBox);
	// }

}
