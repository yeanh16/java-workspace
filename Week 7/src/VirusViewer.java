import javax.swing.JFrame;

public class VirusViewer {
	public static void main(String[] args)
	{
	 
		int population = 10000;
		Population pop = new Population(population,0.8,0.01,0.01);
		
		
		JFrame frame = new JFrame("Plot of infected proportion");
		
		int frameSize = 600;
		
		frame.setSize((frameSize/5)+frameSize+30, frameSize+60);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VirusComponent comp = new VirusComponent(pop,frameSize);
		// get proportion infected and assign it to array
		for(int i=0;i<1000;i++)
		{
			pop.update();
			comp.addProp(i,pop.proportionInfected());
		}
		
		frame.add(comp);
		frame.setVisible(true);
	}
}
