/**
Describes a person and whether or not they are infected with a disease.
*/
public class Person
{
	private boolean infected;
	
	/**
	Create an uninfected person
	*/
	public Person()
	{
		this.infected = false;
	}
	
	
	public String toString()
	{
		if(this.infected)
		{
			return "sick person";  
		}
		else
		{
			return "well person";
		}
	}
	
	
	
	/**
	Tells us if the person is infected
	@return infection status
	*/
	public boolean isInfected()
	{
		return this.infected;
	}
	
	/**
	Changes the infection status
	@param infected new infection status
	*/
	public void setInfected(boolean infected)
	{
		this.infected = infected;
	}
	
}
	
	
	
	
	
	
