import javax.swing.JFrame;

public class EasterGUI
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Easter date calculator");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Easter easter = new Easter(2015);
		
		EasterComponent panel = new EasterComponent(easter, 1900, 2100,
		2015);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
