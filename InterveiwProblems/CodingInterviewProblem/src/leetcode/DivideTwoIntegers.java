package leetcode;


/*
 * note that, the problem is like we know a and b, to calculate x, like this a/b = x. Obviously that we know bx = a. 
 * therefore, the intuitive solution for this problem would be we add b to b itself x times until larger than a. 
 * It's a reasonable idea, but think about this, if a is Integer.MIN_VALUE, and b is 1, what will happen? Obviously, it's too slow to get a. 
 * 
 * Hence, what we think is how can get a much much much faster? 
 * The idea is we increase b by multiplied by 2 every time, until get a. Here we go.
 * 
 * Pitfalls: mistake I made was :
 * 			1) java doesn't support unsigned type;
 * 			2) Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE(Integer.MIN_VALUE is -2147483648),
 * 			   So what I did here is to change absDivid and absDivisor to long type as well as dividend and divisor;
 * 			3) pay attention to bit shift operators. a << b means a shift to left b bits, c >> d means c shift to right by d bits
 */

import java.util.ArrayList;
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor){
    	
    	long absDivid = Math.abs((long)dividend);
    	long absDivisor = Math.abs((long)divisor);
   
        boolean negative;
        int result = 0;
        if(divisor == 0) return (Integer) null;
        if(dividend == 0 ) return 0;
        
        if((dividend < 0 && divisor < 0)||(dividend > 0 && divisor > 0))
            negative = false;
        else
            negative = true;
            
       ArrayList<Long> inc = new ArrayList<Long>();
       int i = 0;
       
       while(absDivisor <= absDivid){
    	   inc.add(absDivisor);
    	   absDivisor = absDivisor << 1;
           i++;     
       }

       i--;
       while(i >= 0 && absDivid != 0){     // think about the processing here. 
           
           if(inc.get(i) <= absDivid){
               absDivid = absDivid - inc.get(i);
               result += 1 << i;
           }   
           i--;
       }
       
       return negative==true?-result:result;
        
    }
	public static void main(String[] args) {
		System.out.println( DivideTwoIntegers.divide(8, 2));
	}
}
