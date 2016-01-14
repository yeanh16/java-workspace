/**
 * a 2d array of booleans indicating whether or not a particular area has a poor signal
 */

public class SignalMap 
{
	private boolean[][] signalMap;
	private double threshold;
	private int size;
	private Network network;
	
	/**
	initialises a Signal Map with true/false set according to signal threshold strength
	@param net the network of transmitters
	@param range the maximum value of the location coordinates
	*/
	public SignalMap(double threshold,int size,Network network)
	{
		this.threshold=threshold;
		this.size=size;
		this.network=network;
		signalMap = new boolean[size][size];
		
		
		for(int i = 0; i < size; i++)
		{			
			for(int j = 0; j < size; j++)
			{
				if(network.getSignal(i, j)<threshold)
				{
					signalMap[i][j]=true;
				}
				else
				{
					signalMap[i][j]=false;
				}
			}
		}
	}
	
	/**
	 * method to display the signal map
	 * @return The signal map
	 */
	public String displaySignalMap()
	{
		String display = "";
		for(int i = 0; i < size; i++)
		{			
			for(int j = 0; j < size; j++)
			{
				if(signalMap[i][j]==true)
				{
					display=display+("[X]");
				}
				else
				{
					display=display+("[ ]");				}
			}
			display=display+'\n';
		}
		return display;
		
	}
	
	/**
	 * method that finds out the fraction of areas that have a poor signal
	 * @return The fraction of the map with poor signal
	 */
	public String poorSignal()
	{
		int poorCount=0;
		for(int i = 0; i < size; i++)
		{			
			for(int j = 0; j < size; j++)
			{
				if(signalMap[i][j]==true)
				{
					poorCount++;
				}
			}
		}
		return poorCount+"/"+(size*size);
	}
	
	/**
	 * method that works out the which transmitter contributes the most coverage
	 * @return The transmitter with most coverage
	 */
	public Transmitter important()
	{
		int most=0;
		int goodSignalCount;
		Transmitter tm = null;
		Transmitter bestTM=null;
		for(int x =0;x<network.size();x++)
		{
			goodSignalCount=0;
			tm = this.network.getTransmitter(x);
			for(int i = 0; i < size; i++)
			{			
				for(int j = 0; j < size; j++)
				{
					if(tm.getSignal(i, j)>threshold)
					{
						goodSignalCount++;
					}
				}
			}
			if(goodSignalCount>most) 
			{
				most=goodSignalCount;
				bestTM = tm;
			}
		}
		return bestTM;
	}
	
	/**
	 * method that compares two signalmaps and shows the areas where the second signalmap has above threshold signal than the first one
	 * @return The display of areas that the second signal map network has better coverage of
	 * @param network2 The signal map that is used to compare with
	 */
	public String compare(SignalMap network2)
	{
		String display = "";
		for(int i = 0; i < size; i++)
		{			
			for(int j = 0; j < size; j++)
			{
				if(this.signalMap[i][j]==true && network2.signalMap[i][j]==false)
				{
					display=display+("[ ]");
				}
				else
				{
					display=display+("[X]");				
				}
			}
			display=display+'\n';
		}
		return display;
	}
}

