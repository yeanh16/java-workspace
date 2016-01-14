public class Test
{

	public static void main(String[] args)
	{
		Easter easter = new Easter(2015);
		System.out.println("Date: " + easter.getDate());
		System.out.println("Month: " + easter.getMonth());
		easter.setYear(1966);
		System.out.println("Date: " + easter.getDate());
		System.out.println("Month: " + easter.getMonth());
	}
}
