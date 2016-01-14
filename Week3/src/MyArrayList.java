
public class MyArrayList 
{
	private String[] array ;
	private int arrayCounter=0;
	private int arrayTCounter=1;
	//constructor
	public MyArrayList()
	{
		this.array = new String[10];
	}
	
	public String toString()
	{
		return "My array list: " + this.array;
	}
	
	//add method (Q4b)
	public void addString(String string)
	{
		if (!(arrayCounter==array.length))
		{
			this.array[arrayCounter]=string;
			arrayCounter++;
			
		}
		else
		{
			String[] tempArray = new String[arrayTCounter*10];
			//copy values
			System.arraycopy(this.array, 0,tempArray , 0, (arrayTCounter*10));
			this.array = new String[(arrayTCounter+1)*10];
			//copy values
			System.arraycopy(tempArray, 0,this.array , 0, (arrayTCounter*10));
			array[arrayCounter]=string;
			arrayCounter++;
			arrayTCounter++;
			
		}
	}
		
	//get method
	public String getMyArrayList(int index)
	{
		if(index>=0 && index <= arrayCounter)
		{
			return this.array[index];
		}
		else
		{
			System.out.println("The following index is out of bounds");
			return null;
		}
		
	}
		
}

