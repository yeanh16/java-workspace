import javax.swing.JSlider;
import java.util.Observer;
import java.util.Observable;

public class SliderControl extends JSlider implements Observer
{
	private SunflowerModel model;
	
	public SliderControl(SunflowerModel model, int min, int max, int value)
	{
		super(min, max, value);
		this.model = model;
	}
	
	public void update(Observable obs, Object obj)
	{
		setValue((int)(model.getAngle() * 100));
	}
}
