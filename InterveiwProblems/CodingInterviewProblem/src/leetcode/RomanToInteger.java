package leetcode;

/*
 *  it's another version of Integer to Roman.
 *  every time we store the previous number, if the previous number less than current number, 
 *  it means the real value should be cur - pre, for example, 9 -> IX;
 *  note1 is used to deal with such case;
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        int pre = Integer.MAX_VALUE;
        int cur;
        for(int i = 0; i < s.length(); i ++){
            cur = map(s.charAt(i));
            result += cur;
            if(pre < cur) result -= 2*pre; //note1
            pre = cur;
        }
        
        return result;
    }
    
    public int map(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
	public static void main(String[] args) {
	
	}
}
