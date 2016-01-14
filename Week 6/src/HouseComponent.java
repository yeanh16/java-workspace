
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
Component containing a house
*/
public class HouseComponent extends JComponent
{
	private House home;
	
	/**
	Create a component with a particular house location
	@param xCoord x coordinate of house
	@param y coordinate of house
	*/
	public HouseComponent(int xCoord, int yCoord,int size)
	{
		super();
		home = new House(xCoord, yCoord, size);
	}
	
	/**
	paint component on graphics object
	@param g the graphics object
	*/
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		home.draw(g2);
	}
}