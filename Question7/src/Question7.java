import java.util.Scanner;

public class Question7
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
			boolean prime = true;
			for (int i=2;2*i<userInput;i++)
			{
				if(userInput%i==0)
				{
					prime=false;
				}				
			}
			if(prime==true)
			{
				System.out.println(userInput+" is a prime");
			}
			else
			{
				System.out.println(userInput+" is not a prime");
			}
		}
	}
}
