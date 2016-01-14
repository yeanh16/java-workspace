import java.util.Random;
import java.util.Scanner;

 public class Test1
 {
	public static void main(String[] args){
		Random generator = new Random();

		while(generator.nextDouble() < 0.8)
		{
		     System.out.printline("looping");
		}
}}