
/**
 Represents the location and power of a mobile phone transmitter
*/

public class Transmitter
{
	private double xCoord;
	private double yCoord;
	private double power;
	private final double limit = 1.0;
	
	/**
	Create a new transmitter at given location with given power.
	@param xCoord the x coordinate
	@param yCoord the y coordinate
	@param power the power of the transmitter
	*/
	public Transmitter(double xCoord, double yCoord, double power)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.power = power;
	}
	
	
	public String toString()
	{
		return "Transmitter located at " + xCoord + ", " + yCoord;
	}
	
	/**
	Find signal strength of a mobile phone 
	@param x x coordinate of phone
	@param y y coordinate of phone
	@return signal strength at that location
	*/
	public double getSignal(double x, double y)
	{
		double distance = Math.sqrt((xCoord - x)*(xCoord - x) 
					+ (yCoord - y)*(yCoord - y));
		if(distance < limit)
		{
			return power;
		}
		else
		{
			return power/(distance * distance);
		}
	}
	
	
	
	
	
	
	
}

	
	
	

	
	
	
	
	