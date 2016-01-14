import java.util.Scanner;
import java.util.ArrayList;


public class Question3
{
	public static void main(String[] args) 
	{  
		Scanner in = new Scanner(System.in);     
		ArrayList<String> list = new ArrayList<String>();     
		System.out.println("Enter a string (enter stop to finish)");  
		String s = in.nextLine();  
		while(!s.equals("stop"))  
		{   
			if(s.length()>3)
			{
			list.add(s.substring(0,3));       
			System.out.println("Enter a string (enter stop to finish)");   
			s = in.nextLine();  
			}
			else
			{
				list.add(s);       
				System.out.println("Enter a string (enter stop to finish)");   
				s = in.nextLine(); 
			}
		}   
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
}