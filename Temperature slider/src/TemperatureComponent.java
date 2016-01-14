import javax.swing.JPanel;
import javax.swing.JSlider;

public class TemperatureComponent extends JPanel
{

	public TemperatureComponent(Temperature temp, int min, int max, int initial)
	{
		super();
		
		// model 
		TemperatureModel model = new TemperatureModel(temp);
		
		// views
		CelciusView celcius = new CelciusView(model);
		FahrenheitView fahrenheit = new FahrenheitView(model);
		
		// make views observe model
		model.addObserver(celcius);
		model.addObserver(fahrenheit);
		
		// create control
		JSlider slider = new JSlider(min, max, initial);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing((max - min)/4);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels((max-min)/4));
		
		// create listener
		SliderListener listen = new SliderListener(model, slider);
		
		// make listeners listen to controls
		slider.addChangeListener(listen);
		
		// place views and controls on panel
		add(celcius);
		add(slider);
		add(fahrenheit);
	}
}
		
		
		
		
		
		
