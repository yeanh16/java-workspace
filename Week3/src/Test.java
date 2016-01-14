
public class Test {
	public static void main(String[] args)
	{
	
		Module sw = new Module("Software Workshop", "Jon Rowe");
		
		System.out.println(sw);
		
		System.out.println(sw.getName());
		System.out.println(sw.getLecturer());
		
		System.out.println("changing lecturer");
		sw.setLecturer("Martin Escardo");
		
		System.out.println(sw);
		
		Student alf = new Student("Alfred Smith", 12345);
		
		System.out.println(alf);
		System.out.println(alf.getName());
		System.out.println(alf.getId());
		
		System.out.println("changing id");
		alf.setId(54321);
		System.out.println(alf);
		
		alf.setModule(0, sw);
		alf.setModule(1, new Module("Foundations", "Dan Ghica"));
		alf.setModule(2, new Module("Intro to AI", "Volker Sorge"));
		
		//System.out.println(alf.getModule(1));
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println(alf.getModule(i));
		}		
		
		//test out compare module (Q1)
		Module sw1 = new Module("Software Workshop", "Bob Bob");
		System.out.println("Compare module name result is: " + sw1.equals(sw));
		
		//test to see if a student is on a module (Q2)
		Module sw2 = new Module("Maths", "Randy Randy");
		System.out.println("Is student on this module? : " + alf.onModule(sw1));
		
		//test to get and set tutor and display information (toString)(Q3b)
		TutorGroup tg = new TutorGroup("Ben Frank");
		tg.setName("Bob Frank");
		System.out.println("Get tutor name: " + tg.getName());
		System.out.println(tg);
		
		//test to add student to tutor group (Q3c)
		tg.addStudent("Steve");
		tg.addStudent("Tom");
		tg.addStudent("Elise");
		System.out.println("Get student array: " + tg.getStudents());
		
		
	}

}
