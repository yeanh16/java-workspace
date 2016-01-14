import javax.swing.event.*;
import javax.swing.JSlider;


public class SliderListener implements ChangeListener
{

	private TemperatureModel model;
	private JSlider slider;

	public SliderListener(TemperatureModel model, JSlider slider)
	{
		this.model = model;
		this.slider = slider;
	}

	public void stateChanged(ChangeEvent e)
	{
		int value = slider.getValue();
		model.setCelcius(value);
	}
}
