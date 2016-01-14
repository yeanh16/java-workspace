import java.util.Arrays;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
	    Integer[] arr1 = new Integer[100];
	    for (int i = 0; i < 100; i++) {
	        arr1[i] = i;
	    }
	    Collections.shuffle(Arrays.asList(arr1));
	    
	    int j = Character.getNumericValue((String.valueOf(Math.abs((long)19)).charAt(1)));
	    System.out.println(j);
	    System.out.println(Arrays.toString(arr1));

	    
		
		    
	}
}
