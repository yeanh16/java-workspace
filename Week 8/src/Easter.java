/**
 * Calculating the date of easter for a particular year
 *
 */
public class Easter
{
	private int year;
	private int a;	
	private int b;	
	private int c;	
	private int d;	
	private int e;	
	private int f;	
	private int g;	
	private int h;
	private int i;	
	private int k;	
	private int L;
	private int m;
	private int date;
	private int month;

	/**
	 * Construct easter 
	 * @param y The year which we wish to find out the date of Easter
	 */
	public Easter(int y)
	{
		this.year = y;
		a = y % 19;
		b = Math.floorDiv(y,100);
		c = y % 100;
		d = Math.floorDiv(b, 4);
		e = b % 4;
		f = Math.floorDiv(b+8 ,25);
		g = Math.floorDiv( b - f + 1, 3);
		h = (19 * a +  b - d - g + 15) % 30;
		i = Math.floorDiv(c, 4);
		k = c % 4;
		L = (32 + 2 * e + 2*i - h - k) % 7;
		m = Math.floorDiv(a + 11 * h + 22 * L, 451);
		date = ((h + L -7 * m + 114) % 31) + 1;
		month = (int) Math.floor((h + L -7 * m + 114)/ 31);
	}
	
	/**
	 * date of easter
	 * @return the date of easter
	 */
	public int getDate()
	{
		return date;
	}

	/**
	 * month of easter
	 * @return month of easter
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * set the year of finding the date of easter
	 * @param y The year in which we want to find when easter is at
	 */
	public void setYear(int y)
	{
		this.year= y;
		a = y % 19;
		b = Math.floorDiv(y,100);
		c = y % 100;
		d = Math.floorDiv(b, 4);
		e = b % 4;
		f = Math.floorDiv(b+8 ,25);
		g = Math.floorDiv( b - f + 1, 3);
		h = (19 * a +  b - d - g + 15) % 30;
		i = Math.floorDiv(c, 4);
		k = c % 4;
		L = (32 + 2 * e + 2*i - h - k) % 7;
		m = Math.floorDiv(a + 11 * h + 22 * L, 451);
		date = ((h + L -7 * m + 114) % 31) + 1;
		month = (int) Math.floor((h + L -7 * m + 114)/ 31);
	}
	
	/**
	 * gets the year
	 * @return the year
	 */
	public int getYear()
	{
		return this.year;
	}
	
}
	
	
	
	
	
