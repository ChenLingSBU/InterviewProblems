package leetcode;


/*
 * there are two ways to do this problem.
 * 1. use binary search. Note1, if only written as end = x/2, there will cause overflow if x = 2147395599;
 * 
 * 2. use Newtown Iteration method. it's much much much faster than 1. 
 */


public class Sqrt {

    public static int sqrtBinary(int x) {
        long left = 0;
        long right = x;
        long mid;
        long v;
        while(left <= right){
            mid = (left + right)/2;
            v = mid * mid;
            if(v == x) return (int)mid;
            else if(v > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return ((int)left + (int)right)/2;
    }
    
    public static int sqrtNewtown(int x) {
        
    	if(x == 0) return 0;
        double EPS = 0.000000001;
        
        double value = x;
        double last;
        
        do{
        	last = value;    // last used to store last calculated value;
            value = (value + x/value)/2;
        }while(Math.abs(value - last) > EPS);
        
        return (int)last;
    }
	public static void main(String[] args) {
		int x = 2147395599;
		System.out.println(Sqrt.sqrtBinary(x));
		System.out.println(Sqrt.sqrtNewtown(x));
	}
}
