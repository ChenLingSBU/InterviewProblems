package leetcode;

/*
 * Use binary search. 
 * Be careful about the case of n < 0 .
 */


public class Pow {
    public static double pow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            return 1.0/power(x, -n);
        }else{
            return power(x, n);
        }
    }
    
    public static double power(double x, int n){
        
        if(n == 0) return 1;
         
        double v = power(x, n/2);
        
        if(n % 2 == 0)
            return v*v;
         else
            return v*v*x;
    }
	public static void main(String[] args) {
		double x = 5;
		int n = 3;
		System.out.println(Pow.pow(x, n));
	}
}
