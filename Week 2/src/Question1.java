import java.util.Scanner;
import java.util.ArrayList;


public class Question1
{
	public static void main(String[] args) 
	{  
		Scanner in = new Scanner(System.in);     
		ArrayList<String> list = new ArrayList<String>();     
		System.out.println("Enter a string (enter stop to finish)");  
		String s = in.nextLine();
		String longest = s;
		while(!s.equals("stop"))  
		{   
			//compare if string is longer
			if(s.length()>longest.length())
			{
				longest = s;
			}
			list.add(s);       
			System.out.println("Enter a string (enter stop to finish)");   
			s = in.nextLine();  
		}   
		System.out.println("The longest string was "+ longest);
	}
}