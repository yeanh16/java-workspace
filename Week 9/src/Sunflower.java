import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
Vogel's mathematical model of sunflower seed patterns
*/
public class Sunflower
{
	private int numberSeeds;
	private double angle;
	private ArrayList<Point2D.Double> seeds;

/**
Construct sunflower pattern
@param numberSeeds how many seeds to use
@param angle the spiral angle
*/
	public Sunflower(int numberSeeds, double angle)
	{
		this.numberSeeds = numberSeeds;
		this.angle = angle;
		seeds = new ArrayList<Point2D.Double>();
		calculateSeeds();
	}
	
	private void calculateSeeds()
	{
		seeds.clear();
		for(int i = 0; i < numberSeeds; i++)
		{
			double x = 0.5  +  Math.sqrt(i) * Math.cos(angle * i) / 60.0;
			double y = 0.5  -  Math.sqrt(i) * Math.sin(angle * i) / 60.0;
			seeds.add(new Point2D.Double(x, y));
		}
	}


/**
Get the positions of the seeds
@return an ArrayList containing the coordinates of the seeds - should be scaled by diameter of flower
*/
	public ArrayList<Point2D.Double> getSeeds()
	{
		return seeds;
	}


/**
Change the spiral angle
@param angle the new spiral angle
*/
	public void setAngle(double angle)
	{
		this.angle = angle;
		calculateSeeds();
	}
	
/**
Get the current spiral angle
@return the spiral angle
*/
	public double getAngle()
	{
		return angle;
	}
}