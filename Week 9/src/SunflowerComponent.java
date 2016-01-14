import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.JButton;



public class SunflowerComponent extends JPanel
{

	
	public SunflowerComponent(Sunflower flower, int min, int max, int value)
	{
		super();
		
		//create model
		SunflowerModel model = new SunflowerModel(flower);
		
		// create views
		SunflowerView view = new SunflowerView(model);
		
		
		// create controls & listeners
		SliderControl slider = new SliderControl(model, min, max, value);
		//slider.addChangeListener(e-> model.setAngle(slider.getValue()/100.0));

		
			
		slider.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent e)
				{
					int v = slider.getValue(); 
					model.setAngle(v/100.0);
				}
			}
		);

				
		JButton reset = new JButton("Reset");
		//reset.addActionListener(e->model.setAngle(value/100.0));

		reset.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.setAngle(value/100.0);
				}
			}
		);
					
		
		
		
		// make views observe model
		model.addObserver(view);
		model.addObserver(slider);
		
		
		// put views and controls on panel
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);
		add(slider, BorderLayout.SOUTH);
		add(reset, BorderLayout.EAST);
		
	}
}
		
		
		

		
		
