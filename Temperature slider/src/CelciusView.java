import javax.swing.JLabel;
import java.util.Observer;
import java.util.Observable;

/**
Text view of temperature in Celcius
*/
public class CelciusView extends JLabel implements Observer
{
	private TemperatureModel model;
	
	/**
	Initialise view with model
	@param model the underlying temperature model
	*/
	public CelciusView(TemperatureModel model)
	{
		super();
		this.model = model;
		
		double value = Math.floor(10 * model.getCelcius())/10;
		//double value = model.getCelcius();
		setText(value + " Celcius");
	}
	
	public void update(Observable obs, Object obj)
	{
		double value = Math.floor(10 * model.getCelcius())/10;
		//double value = model.getCelcius();
		setText(value + " Celcius");
	}
}
	
	
	
	
	
	
	
