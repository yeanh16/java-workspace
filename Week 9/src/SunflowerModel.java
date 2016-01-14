import java.util.Observable;
import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
Model of sunflower class
*/
public class SunflowerModel extends Observable
{
	private Sunflower flower;

/**
Construct model of sunflower
@param flower the sunflower object
*/
	public SunflowerModel(Sunflower flower)
	{
		super();
		this.flower = flower;
	}
	
/**
Get the positions of the seeds
@return an ArrayList containing the coordinates of the seeds - should be scaled by diameter of flower
*/
	public ArrayList<Point2D.Double> getSeeds()
	{
		return flower.getSeeds();
	}

/**
Get the current spiral angle
@return the spiral angle
*/
	public double getAngle()
	{
		return flower.getAngle();
	}
	
/**
Change the spiral angle
@param angle the new spiral angle
*/
	public void setAngle(double angle)
	{
		flower.setAngle(angle);
		setChanged();
		notifyObservers();
	}
}