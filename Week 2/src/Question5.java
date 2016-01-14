import java.util.Scanner;
import java.util.ArrayList;


public class Question5
{
	public static void main(String[] args) 
	{  
		Scanner in = new Scanner(System.in);     
		ArrayList<String> list = new ArrayList<String>();     
		System.out.println("Enter a string (enter stop to finish)");  
		String s = in.nextLine();  
		while(!s.equals("stop"))  
		{   
			list.add(s);       
			System.out.println("Enter a string (enter stop to finish)");   
			s = in.nextLine();  
		}   
		
		String searchstring ="";
		String mostcommon = "";
		int count=0;
		int mostcount=0;
		for(int i=0;i<list.size();i++)
		{
			searchstring = list.get(i);
			for(int i1=0;i1<list.size();i1++)
			{
				if(searchstring.equalsIgnoreCase(list.get(i1)))
				{
					count++;
				}
				if(count>mostcount)
				{
					mostcount=count;
					mostcommon=list.get(i1);	
				}
			}
		}
		System.out.println("The most frequent string was " + mostcommon);
		int a = "apple".compareTo("Banana");
		System.out.println("apple".compareTo("Banana"));
		list.size();
		int z= list.indexOf("asdnj");
		Boolean b = 3 != 3;
		System.out.println(b);
		int x = 2;

		for(int i= 0; i< 10; i++)

		{

		               x = x + x;

		}

		 
	}
}