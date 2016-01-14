import java.util.Scanner;

public class Question8
{
	

	public static void main(String[] args)
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input an integer");
		int userInput = userInputScanner.nextInt();userInputScanner.nextLine();
		if (userInput<0)
		{
			System.out.println("Input is not greater than 0");

		}
		else
		{
			if(Math.round(Math.sqrt(userInput))==Math.sqrt(userInput))
			{
				System.out.println("The number " + userInput + " is the square of "+ Integer.toString((int)Math.sqrt(userInput)) );
			}
			else
			{
				System.out.println("The number " + userInput + " is not a square.");

			}
		}
}
}