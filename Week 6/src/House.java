import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
	 Construction of house graphics
	 */
public class House {
	
		private Rectangle door ;
		private Rectangle building ;
		private Line2D.Double roof1;
		private Line2D.Double roof2;

		/**
		Create house
		*/
		public House(int xCoord, int yCoord, int size)
		{
			//door = new Rectangle(xCoord+60 , yCoord+60 ,20, 40);	
			//roof1 = new Line2D.Double(xCoord,yCoord,xCoord+50,yCoord-30 );
			//roof2 = new Line2D.Double(xCoord+100,yCoord,xCoord+50,yCoord-30 );
			building = new Rectangle(xCoord, yCoord, size, size);
			door = new Rectangle(xCoord+(size/2) , yCoord+(size/2) ,(size/5), (size/2));	
			roof1 = new Line2D.Double(xCoord,yCoord,xCoord+(size/2),yCoord-(size/3) );
			roof2 = new Line2D.Double(xCoord+size,yCoord,xCoord+(size/2),yCoord-(size/3) );
		}
		
		/**
		Draw the house on a graphics object
		*/
		public void draw(Graphics2D g)
		{
			g.setColor(Color.LIGHT_GRAY);
			g.fill(building);
			g.setColor(Color.WHITE);
			g.fill(door);
			g.setColor(Color.BLACK);
			g.draw(building);
			g.draw(roof1);
			g.draw(roof2);
			g.draw(door);
			

			
		}
}
