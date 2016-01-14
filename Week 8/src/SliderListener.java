import javax.swing.event.*;
import javax.swing.JSlider;


public class SliderListener implements ChangeListener
{

	private EasterModel model;
	private JSlider slider;

	public SliderListener(EasterModel model, JSlider slider)
	{
		this.model = model;
		this.slider = slider;
	}

	public void stateChanged(ChangeEvent e)
	{
		int value = slider.getValue();
		model.setYear(value);
	}
	
}
