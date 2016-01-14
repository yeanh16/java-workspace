import java.util.Observable;

/**
Model of temperature class
*/
public class TemperatureModel extends Observable
{
	private Temperature temp;
	
	public TemperatureModel(Temperature temp)
	{
		super();
		this.temp = temp;
	}
	
	/**
	Get the temperature in Celcius
	@return temperature in Celcius
	*/
	public double getCelcius()
	{
		return temp.getCelcius();
	}
	
	
	/**
	Get the temperature in Fahrenheit
	@return temperature in Fahrenheit
	*/
	public double getFahrenheit()
	{
		return temp.getFahrenheit();
	}
	
	/**
	Change the temperature in Celcius
	@param celcius the new temperature in Celcius
	*/
	public void setCelcius(double celcius)
	{
		temp.setCelcius(celcius);
		setChanged();
		notifyObservers();
	}
	
	/**
	Change the temperature in Fahrenheit
	@param fahrenheit the new temperature in Fahrenheit
	*/
	public void setFahrenheit(double fahrenheit)
	{
		temp.setFahrenheit(fahrenheit);
		setChanged();
		notifyObservers();
	}
}
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
