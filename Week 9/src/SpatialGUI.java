import javax.swing.JFrame;

public class SpatialGUI {
	public static void main(String[] args)
	{
		SpatialNetwork network = new SpatialNetwork(50,0);
		
		SpatialComponent comp = new SpatialComponent(network, 0, 100, 0, 0 , 200 , 50);
		
		JFrame frame = new JFrame("Spatial Network Viewer");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(comp);
		frame.setVisible(true);
	}
}
