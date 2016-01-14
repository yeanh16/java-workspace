import java.util.Random;

public class Test
{
	public static void main(String[] args)
	{
		Transmitter t1 = new Transmitter(1.0, 0.5, 80.0);
		Transmitter t2 = new Transmitter(8.0, 1.2, 80.0);
		Transmitter t3 = new Transmitter(17.5, 17.0, 80.0);
		 
		Network net = new Network();
		net.add(t1);
		net.add(t2);
		net.add(t3);
		
		//test to display signal map
		SignalMap sm = new SignalMap(10,20,net);
		System.out.println(sm.displaySignalMap());
		
		//test for poorSignal
		System.out.println(sm.poorSignal());
		
		//test for important
		System.out.println("Important: "+sm.important());

		//test for compare
		Network net2 = new Network();
		Transmitter t4 = new Transmitter(2.0, 0.5, 80.0);
		Transmitter t5 = new Transmitter(7.0, 8.2, 80.0);
		Transmitter t6 = new Transmitter(17.5, 17.0, 150.0);
		net2.add(t4);
		net2.add(t5);
		net2.add(t6);
		SignalMap sm2 = new SignalMap(10,20,net2);

		 
         int[] aa = {1, 2, 3};

         System.out.println(aa);
         int[][] grid = new int[5][8];
         System.out.println(Math.exp(0));


	}
}