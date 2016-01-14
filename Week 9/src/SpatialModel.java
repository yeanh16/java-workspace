import java.util.Observable;
import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
network of Spatial Network class
*/
public class SpatialModel extends Observable
{
	private SpatialNetwork network;

/**
Construct network of Spatial Network
@param network the Spatial Network object
*/
	public SpatialModel(SpatialNetwork network)
	{
		super();
		this.network = network;
	}
	
/**
Get the positions of the nodes
@return an ArrayList containing the coordinates of the nodes - should be scaled by diameter of network
*/
	public ArrayList<Point2D.Double> getCoords()
	{
		return network.getCoords();
	}

/**
Get the number of nodes
@return the number of nodes
*/
	public double getPoints()
	{
		return network.getPoints();
	}

/**
Get the threshold
@return the threshold
*/
	public double getThreshold()
	{
		return network.getThreshold();
	}
		
	/**
	 * Calculates wheter two nodes should be connected
	 * @param n1 Node 1
	 * @param n2 Node 2
	 * @return If nodes should be connected or not
	 */
	public boolean isConnected(Point2D.Double n1, Point2D.Double n2)
	{
		return network.isConnected(n1,n2);
	}
	
/**
Change the threshold
@param threshold the new threshold
*/
	public void setThreshold(double threshold)
	{
		network.setThreshold(threshold);
		setChanged();
		notifyObservers();
	}
	
/**
Change the number of nodes
@param points the new number of points
*/
	public void setPoints(int points)
	{
		network.setPoints(points);
		setChanged();
		notifyObservers();
	}
}