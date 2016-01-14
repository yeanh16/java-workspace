import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class SunflowerView extends JPanel implements Observer
{
	private SunflowerModel model;
	
	public SunflowerView(SunflowerModel model)
	{
		super();
		this.model = model;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		int height = getHeight();
		int width = getWidth();
		g2.clearRect(0, 0, width, height);
		
		double diameter = Math.min(height, width);
		
		g2.setColor(Color.ORANGE);
		
		// get the array list of points
		ArrayList<Point2D.Double> seeds = model.getSeeds();
		
		// go through list one at a time
		// for each one, create a new Spot and draw it
		for(int i = 0; i < seeds.size(); i++)
		{
			double x = seeds.get(i).getX();
			double y = seeds.get(i).getY();
			Spot p = new Spot(x*diameter, y*diameter, diameter/100.0);
			g2.fill(p);
		}
	}
	
	public void update(Observable obs, Object obj)
	{
		repaint();
	}
	
	
}
		
		
		
		
		
		
		
