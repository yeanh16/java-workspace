import java.util.Scanner;

public class Question4 
{
	
	public static void main(String[] args)
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input a string");
		String userText = userInputScanner.nextLine();
		String newWord = new StringBuilder(userText).reverse().toString();
		System.out.println(userText + " backwards is " + newWord.toLowerCase());
		if (newWord.equalsIgnoreCase(userText))
		{
			System.out.println(userText + " is a palindrome");
		}
		else
		{
			System.out.println(userText + " is not a palindrome");

		}
	}
}
