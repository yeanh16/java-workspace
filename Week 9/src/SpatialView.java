import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class SpatialView extends JPanel implements Observer
{
	
	private SpatialModel model;
	/**
	 * Constructor for spatial view
	 * @param model the network model
	 */
	public SpatialView(SpatialModel model)
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
				
		g2.setColor(Color.BLACK);
		
		double diameter = Math.min(height, width);

		// get the array list of points
		ArrayList<Point2D.Double> nodes = model.getCoords();
		
		// go through list one at a time
		// for each one, create a new Spot and draw it
		for(int i = 0; i < nodes.size(); i++)
		{
			double x = nodes.get(i).getX();
			double y = nodes.get(i).getY();
			Spot p = new Spot(x*diameter, y*diameter, diameter/100.0);
			g2.fill(p);
		}
		
		//go through array of spots to see if they should be connected
		for(int i = 0; i < nodes.size(); i++)
		{
			for (int j = i+1; j<nodes.size();j++)
			{
				if(model.isConnected(nodes.get(i),nodes.get(j)))
				{
					g2.draw(new Line2D.Double(nodes.get(i).getX()* diameter  ,nodes.get(i).getY()* diameter , nodes.get(j).getX()* diameter,nodes.get(j).getY()* diameter));
				}
			}
		}

	}
	
	public void update(Observable obs, Object obj)
	{
		repaint();
	}
	
	
}