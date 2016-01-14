import java.util.Scanner;

public class Question6
{
	

	public static void main(String[] args)
	{
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("Please input a string");
		String userInput = userInputScanner.nextLine();
		char letter = 0;
		String leftovers="";
		int loopnumber = userInput.length();
		
		for(int loop=1;loop<loopnumber;loop++)
		{	
			int stringlength = userInput.length();
			letter = userInput.charAt(0);
			for(int i=0;i<stringlength;i++)
			{
				if(userInput.charAt(i)<letter)
				{
					letter = userInput.charAt(i);
				}
			}
		System.out.println(letter);
			//make up new word from leftover letters
			leftovers="";
			for(int w=0;w<stringlength;w++)
			{
				if(userInput.charAt(w) != letter|| "".equals(userInput.charAt(w)))
				{
					leftovers= leftovers+userInput.charAt(w);
				}
			}		
			userInput=leftovers;

		}
		System.out.println(leftovers);

	}
}