import java.util.ArrayList;

public class TutorGroup 
{
	//data fields
	private String name;
	private ArrayList<String> students; ;

	//constructor
	public TutorGroup(String name)
	{
		this.name = name;
		this.students = new ArrayList<String>(); 
	}
	
	// toString method

	public String toString()
	{
		return "Tutor: " + this.name + ", Students: " + this.students;
	}

	//get methods
	public String getName()
	{
		return this.name;
	}
			
	

	//set methods
	public void setName(String name)
	{
		this.name = name;
	}
	
	//add student
	public void addStudent(String student) 
	{
		this.students.add(student);
	}
	//get student which returns ArrayList of students
	public ArrayList<String> getStudents()
	{
		return this.students;
	}
	

}
