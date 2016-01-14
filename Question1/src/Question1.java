import java.util.Scanner;
public class Question1 
{
	public static void main(String[] args) 
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input a number");
		int userInputNumber = userInputScanner.nextInt();userInputScanner.nextLine();
		if ( ( userInputNumber & 1 ) == 0 )
			{
				while (userInputNumber>0) 
				{
					userInputNumber=userInputNumber-2;
					System.out.println(userInputNumber);
				}
			}
		else 
			{ 
				userInputNumber= userInputNumber-1;
				System.out.println(userInputNumber);
					while (userInputNumber>0)
					{
						userInputNumber=userInputNumber-2;
						System.out.println(userInputNumber);
					}
					
			}
	}
}
