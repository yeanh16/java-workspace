
public class Module 
{
	private String name;
	private String lecturer;
	
	//constructor
	public Module(String name, String lecturer)
	{
		this.name = name;
		this.lecturer = lecturer;
	}
	
	public String toString()
	{
		return "Module: " + this.name + ", " + this.lecturer;
	}
	
	// get methods
	public String getName()
	{
		return this.name;
	}
	
	public String getLecturer()
	{
		return this.lecturer;
	}
	
	// set methods
	public void setLecturer(String lecturer)
	{
		this.lecturer = lecturer;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	

	//Compare if two modules have the same name
	Module compare; 
	public boolean equals(Module module) 
	{
			if(this.name.equals(module.name))
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
}
