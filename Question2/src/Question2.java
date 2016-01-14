import java.util.Scanner;
public class Question2 
{
	public static void main(String[] args)
	{
		int lowest = 999999999;
		Scanner userInputScanner = new Scanner(System.in);
		int userInputNumber =0;
		boolean haschanged=false;
		while(userInputNumber>=0)
		{
			System.out.println("Please input a number");
			userInputNumber = userInputScanner.nextInt();userInputScanner.nextLine();
			if(userInputNumber<=lowest && userInputNumber>=0)
			{
				lowest = userInputNumber;
				haschanged=true;
			}
			else
			{
			}
		}
		if(haschanged==false)
		{
			System.out.println("No positive number entered");

		}
		else
		{
		System.out.println("The smallest number was " + lowest);
		}
	}
}
