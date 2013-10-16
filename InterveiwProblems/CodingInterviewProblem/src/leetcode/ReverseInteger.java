package leetcode;

/*
 * as the problem mentioned two cases, 1. integer's last digit is 0. 2. overflow
 * 
 * The way to tackle 1 is as note1. 
 * The way to tackle 2 is use a long type variable to store result, and check before return; as note2.
 */
import java.util.ArrayList;
public class ReverseInteger {

    public int reverse(int x) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        long result = 0;
        int multi = 1;
        int flag = 0;
        if(x > 0)
          flag = 1;
        else{
            flag = -1;
            x *= -1;
        }
        
        
        while(x != 0){
            digits.add(x%10);
            x /= 10;
        }
        
        for(int i = digits.size() - 1; i >= 0; i--){ //note1
            result += digits.get(i) * multi; 
            multi *= 10;
        }
        result *= flag;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE; //note2.
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)result;
      }
    
	public static void main(String[] args) {
		
	}
}
