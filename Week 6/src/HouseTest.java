
import javax.swing.JFrame;

public class HouseTest {
	public static void main(String[] args)
	{
		
		
		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.setTitle("My Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StreetComponent house = new StreetComponent(100, 100,100,10);
		//HouseComponent house = new HouseComponent(100, 100,300);
		frame.add(house); 
		
		frame.setVisible(true);
	}
}
