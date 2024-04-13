import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
	private StoreModel model;
	private StoreView store;
	
	/**
	 * Constructor for Controller class
	 * @param model
	 * @param view
	 */
	public Controller(StoreModel model, StoreView view)
	{
		this.model = model;
		this.store = view;
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
