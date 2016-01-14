import java.util.Scanner;
import java.util.ArrayList;


public class Question2
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
		for(int i=list.size()-1;i>=0;i--)
		{
			System.out.println(list.get(i));
		}
	}
}