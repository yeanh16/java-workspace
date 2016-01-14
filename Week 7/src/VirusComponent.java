import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
Component which draws a graph of proportion infected
*/
public class VirusComponent extends JComponent
{
	private Population pop;
	private double[] infectedPeopleProportion;
	private int frameSize;
	
	/**
	Construct component 
	@param pop the population 
	@param frameSize size of the map
	*/
	public VirusComponent(Population pop, int frameSize)
	{
		super();
		this.pop = pop;
		this.frameSize = frameSize;
		infectedPeopleProportion = new double[1000];
		
	}
	
	/**
	 * add to array the proportion infected
	 * @param prop The proportion infected
	 * @param i The position in array to be stored
	 */
	public void addProp (int i,double prop)
	{
		infectedPeopleProportion[i] = pop.proportionInfected();
	}
	
	public void paintComponent(Graphics g)
		{
		frameSize = getWidth();
		int yScale = (frameSize/5)*3;
		Graphics2D g2 = (Graphics2D)g;
		
		//draw axes
		g2.setColor(Color.BLACK);
		g2.drawString("Infected proportion", (frameSize/5)-80,(frameSize/5));
		g2.drawLine(frameSize/5, (frameSize/5)*4, frameSize/5,(frameSize/5));//y
		g2.drawString("Time", ((frameSize/5)+(frameSize/5)+frameSize)/2, (frameSize/5)*4+20);
		g2.drawLine(frameSize/5, (frameSize/5)*4, (frameSize/5)+frameSize,(frameSize/5)*4);//x

		for(int i = 0; i < frameSize; i++)
		{
			//scale the plot to axes
			int y = (int) (infectedPeopleProportion[i] * yScale); 
			// create pixel at location within axes
			Rectangle pixel = new Rectangle(i+(frameSize/5),(frameSize-y)-(frameSize/5), 1, 1);
			// draw pixel using "fill" method
			g2.fill(pixel);
		}
	}
}