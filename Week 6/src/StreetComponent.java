
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
A component to hold a rectangle
*/
public class StreetComponent extends JComponent
{
	private int xCoord;
	private int yCoord;
	private int size;
	private int noOfHouses;
	private House[] array;
	
	/**
	Construct a component with specified coordinates for houses location
	@param xCoord x coordinate of top-left corner
	@param yCoord y coordinate of top left corner
	*/
	public StreetComponent(int xCoord, int yCoord,int size, int noOfHouses)
	{
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
		this.noOfHouses = noOfHouses;
		this.array=new House[noOfHouses];
		for(int i=0;i<noOfHouses;i++)
		{
			array[i]= new House(xCoord+(i*size)+(i*10),yCoord,size);
		}
	}


	/**
	Draw a street of houses
	@param g the graphics object
	*/
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;	
		for(int i=0;i<noOfHouses;i++)
		{
			House h = array[i];
			h.draw(g2);
		}
	}
}