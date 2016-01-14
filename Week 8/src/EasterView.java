import javax.swing.JLabel;
import java.util.Observer;
import java.util.Observable;

/**
Text view of date of easter
*/
public class EasterView extends JLabel implements Observer
{
	private EasterModel model;
	
	/**
	Initialise view with model
	@param model the underlying easter model
	*/
	public EasterView(EasterModel model)
	{
		super();
		this.model = model;
		
		int date = model.getDate();
		int month = model.getMonth();
		int year = model.getYear();
		String m;
		if (month ==4)
		{
			m = "April";
		}
		else
		{
			m = "March";
		}
		setText("In the year " + year + " Easter was on the " + date + " " + m);
	}
	
	public void update(Observable obs, Object obj)
	{
		int date = model.getDate();
		int month = model.getMonth();
		int year = model.getYear();
		String m;
		if (month ==4)
		{
			m = "April";
		}
		else
		{
			m = "March";
		}
		setText("In the year " + year + " Easter was on the " + date + " " + m);
	}
}