import java.util.Scanner;
import java.util.ArrayList;


public class Question4
{
	public static void main(String[] args) 
	{  
		Scanner in = new Scanner(System.in);     
		ArrayList<String> list = new ArrayList<String>();     
		System.out.println("Enter a string (enter stop to finish)");  
		String s = in.nextLine();  
		while(!s.equals("stop"))  
		{   
			if(!list.contains(s))
			{
				list.add(s);       
			}
			System.out.println("Enter a string (enter stop to finish)");   
			s = in.nextLine();  
			
		}   
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
}