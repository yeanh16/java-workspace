package git.part1;

import java.util.*;

public class lotto {
  

    public static void main(String[] args) 
    {
    	int count = 1;
       List<Integer> numbers = new ArrayList();
       for (int i=1;i<20;i++)
       {
    	   numbers.add(i);
       }
       
       double total = 0;
       
       for(int i=1; i<100;i++)
       {
    	   boolean flag = false;
    	   count=1;
    	   while (flag == false)
    	   {
    		   Collections.shuffle(numbers);
    		   if(numbers.get(1) == 1 ||numbers.get(1) == 2||numbers.get(1) == 3 && numbers.get(2)==2||numbers.get(2) == 1||numbers.get(2) == 3 && numbers.get(3)==3||numbers.get(3) == 2||numbers.get(3) == 1 )
    		   {
    			   total = total + count;
    			   flag = true;
    		   }
    		   else
    		   {
    			   count++;
    		   }
    	   }
       }
       System.out.println(total);
    }
  } 

