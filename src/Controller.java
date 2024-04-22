import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 * 
 * Class Responsibilities:
 * 
 */

// controller is an Action Listener
public class Controller implements ActionListener
{
	// the controller...
	// has a model
	private StoreModel model;
	// has a view
	private StoreView view;
	
	/**
	 * Constructor for Controller class
	 * @param model
	 * @param view
	 */
	public Controller(StoreModel model, StoreView view)
	{
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Event listener
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	
}
