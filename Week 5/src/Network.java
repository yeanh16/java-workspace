/**
Network of several transmitters.
*/

import java.util.ArrayList;

public class Network
{
	private ArrayList<Transmitter> stations;
	
	/**
	Create a network with initially no transmitters
	*/
	public Network()
	{
		this.stations = new ArrayList<Transmitter>();
	}
	
	/**
	Add a transmitter to the network
	@param t transmitter to be added
	*/
	public void add(Transmitter t)
	{
		stations.add(t);
	}
	
	/**
	How many transmitters are in the network
	@return number of transmitters
	*/
	public int size()
	{
		return stations.size();
	}
	
	/**
	Get the tansmitter at a given index
	@param index the index of the transmitter
	@return the transmitter at that index
	*/
	public Transmitter getTransmitter(int index)
	{
		return stations.get(index);
	}
	
	
	/**
	Return the signal strength at a particular location
	@param x the x coordinate
	@param y the y coordinate
	@return maximum signal from transmitters in the network
	*/
	public double getSignal(double x, double y)
	{
		double best = 0.0;
		for(int i = 0; i < size(); i++)
		{
			double signal = getTransmitter(i).getSignal(x, y);
			if(signal > best)
			{
				best = signal;
			}
		}
		return best;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	