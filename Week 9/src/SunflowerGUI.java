import javax.swing.JFrame;

public class SunflowerGUI
{
	public static void main(String[] args)
	{
		Sunflower flower = new Sunflower(800, 2.4);
		
		SunflowerComponent comp = new SunflowerComponent(flower, 0, 400,
		240);
		
		JFrame frame = new JFrame("Sunflower Viewer");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(comp);
		frame.setVisible(true);
	}
}
