import java.util.Observable;

/**
Model of Easter class
*/
public class EasterModel extends Observable
{
	private Easter easter;
	public EasterModel(Easter easter)
	{
		super();
		this.easter = easter;
	}
	
	/**
	Get the date 
	 * @return the date
	*/
	public int getDate()
	{
		return easter.getDate();
	}
	
	/**
	Get the month 
	 * @return the month
	*/
	public int getMonth()
	{
		return easter.getMonth();
	}
	
	
	/**
	Change the year
	@param y the new year
	*/
	public void setYear(int y)
	{
		easter.setYear(y);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get the year
	 * @return The year
	 */
	public int getYear()
	{
		return easter.getYear();
		
	}
	
}
	