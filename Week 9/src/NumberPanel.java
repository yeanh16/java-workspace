import java.util.Observable;
import java.util.Observer;
import javax.swing.JSlider;


public class NumberPanel extends JSlider implements Observer
{
private SpatialModel model;
	/**
	 * constructor for Number Panel
	 * @param model the network model
	 * @param min min value of slider
	 * @param max max value of slider
	 * @param value default value of slider
	 */
	public NumberPanel(SpatialModel model, int min, int max, int value)
	{
		super(min, max, value);
		this.model = model;
	}
	
	public void update(Observable obs, Object obj)
	{
		setValue((int)(model.getPoints()));
	}
	
	
}
