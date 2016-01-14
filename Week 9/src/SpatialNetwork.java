import java.awt.geom.Point2D;
import java.util.ArrayList;
/**
 * Spatial network of random points in a 2D area
 */
	public class SpatialNetwork
	{
		private int points;
		private double threshold;
		private ArrayList<Point2D.Double> nodes;

		
	
	/**
	 * Construct a network of random points
	 * @param points The number of nodes for graph
	 * @param threshold The threshold for points to be connected or not
	 */
	public SpatialNetwork(int points, double threshold)
	{
		this.points=points;
		this.threshold=threshold;
		nodes = new ArrayList<Point2D.Double>();
		calculateNodes();
	}
	
	/**
	 * creates randomised points
	 */
	private void calculateNodes()
	{
		nodes.clear();
		for(int i = 0; i < points; i++)
		{
			double x = Math.random();
			double y = Math.random();
			nodes.add(new Point2D.Double(x, y));
		}
	}
	
	/**
	 * Gets co-ordinates of a node
	 * @param n The node that we need the coords of
	 * @return The cordinates of a node
	 */
	public ArrayList<Point2D.Double> getCoords()
	{
		return nodes;
	}
	
	/**
	 * Gets the number of nodes
	 * @return number of nodes
	 */
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * Gets the threshold
	 * @return The threshold
	 */
	public double getThreshold()
	{
		return threshold;
	}
	
	/**
	 * Calculates if two nodes should be connected
	 * @param n1 Node 1 
	 * @param n2 Node 2
	 * @return Whether nodes should be connected or not
	 */
	public boolean isConnected(Point2D.Double n1, Point2D.Double n2)
	{
		double c =((((n1.x)-(n2.x))*((n1.x)-(n2.x)))+(((n1.y)-(n2.y))*((n1.y)-(n2.y))));
		if (Math.sqrt(c)*100 < getThreshold())
				{
				return true;
				}
		else
				{
				return false;
				}
	}
	
	/**
	 * Sets threshold
	 * @param threshold The threshold
	 */
	public void setThreshold(double threshold)
	{
		this.threshold=threshold;
	}
	
	/**
	 * Sets number of nodes
	 * @param points The number of nodes
	 */
	public void setPoints(int points)
	{
		this.points = points;
		calculateNodes();
	}
}
	
