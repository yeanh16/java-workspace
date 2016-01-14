import java.util.Scanner;

public class Question5
{
	

	public static void main(String[] args)
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input a string");
		String userInput = userInputScanner.nextLine();
		int stringlength = userInput.length();
		char first = userInput.charAt(0);
		for(int i=0;i<stringlength;i++)
		{
			if(userInput.charAt(i)<first)
			{
				first = userInput.charAt(i);
			}
		}
		System.out.println("The first character alphabetically is " + first);

	}
}