import javax.swing.JPanel;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;



public class SpatialComponent extends JPanel
{
/**
 * component of network
 * @param network the network
 * @param min the min of threshold slider
 * @param max the max of threshold slider
 * @param value the default value of threshold slider
 * @param nmin the min of points slider
 * @param nmax the max of points slider
 * @param nvalue the default value of points slider
 */
	
	public SpatialComponent(SpatialNetwork network, int min,int max,int value, int nmin, int nmax, int nvalue)
	{
		super();
		
		//create model
		SpatialModel model = new SpatialModel(network);
		
		// create views
		SpatialView view = new SpatialView(model);
		
		
		// create controls & listeners
		ThresholdPanel Tslider = new ThresholdPanel(model, min, max, value);
		Tslider.setPaintTicks(true);
		Tslider.setMajorTickSpacing((max - min)/4);
		Tslider.setPaintLabels(true);
		Tslider.setLabelTable(Tslider.createStandardLabels((max-min)/4));
		Tslider.setBorder(BorderFactory.createTitledBorder("Threshold"));		
		
		//slider.addChangeListener(e-> model.setAngle(slider.getValue()/100.0));
		Tslider.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent e)
					{
					int v = Tslider.getValue(); 
					model.setThreshold(v);
				}
			}
		);

		NumberPanel Nslider = new NumberPanel(model, nmin, nmax, nvalue);
		Nslider.setPaintTicks(true);
		Nslider.setMajorTickSpacing((max - min)/4);
		Nslider.setPaintLabels(true);
		Nslider.setLabelTable(Nslider.createStandardLabels((max-min)/4));
		Nslider.setBorder(BorderFactory.createTitledBorder("Points"));		
		
		Nslider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
				{
				int h = Nslider.getValue(); 
				model.setPoints(h);
			}
		}
	);

		
		ButtonPanel reset = new ButtonPanel(model);
		
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.setThreshold(0);
				model.setPoints(50);
			}
		}
	);
		
		ButtonPanel exit = new ButtonPanel(model);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
	);
		exit.setText("Exit");		
		reset.setText("Reset");
		
		
		
		// make views observe model
		model.addObserver(view);
		model.addObserver(Tslider);
		model.addObserver(Nslider);
		
		// put views and controls on panel
		setLayout(new BorderLayout());
		JPanel eastPanel = new JPanel();
		eastPanel.add(exit, BorderLayout.NORTH);
		eastPanel.add(reset, BorderLayout.SOUTH);
		
		add(eastPanel,BorderLayout.EAST);
		add(view, BorderLayout.CENTER);
 		add(Tslider, BorderLayout.SOUTH);
 		add(Nslider, BorderLayout.NORTH);
 		
 	
	}
}