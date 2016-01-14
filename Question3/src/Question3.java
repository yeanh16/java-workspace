import java.util.Arrays;
import java.util.Scanner;

public class Question3 
{
	public static void main(String[] args)
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input a number");
		int userInputNumber = userInputScanner.nextInt();userInputScanner.nextLine();
		if(userInputNumber<0)
			{
			System.out.println("Positive number is required");
			}
		else
		{
			for ( int i=userInputNumber;i>0;i=i-1)
			{
				String STARS = repeatChar('*',i);
				System.out.println(STARS);

			}
		}
	}

	private static String repeatChar(char c, int i) {
		char[] data = new char[i];
	    Arrays.fill(data, c);
	    return new String(data);
	}
}
