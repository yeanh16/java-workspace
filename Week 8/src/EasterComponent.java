import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class EasterComponent extends JPanel
{

	public EasterComponent(Easter easter, int min, int max, int initial)
	{
		super();
		Observer obs = new Observer();
		// model 
		EasterModel model = new EasterModel(easter);
		
		// views
		EasterView view = new EasterView(model);
		
		// make views observe model
		model.addObserver(view);
		
		// create control
		JSlider slider = new JSlider(min, max, initial);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing((max - min)/4);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels((max-min)/3));
		
		// create listener
		SliderListener listen = new SliderListener(model, slider);
		
		// make listeners listen to controls
		slider.addChangeListener(listen);
		
		// place views and controls on panel
		add(slider);
		add(view);
	}
}