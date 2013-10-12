package leetcode;


/*
 * should consider all the cases:
 * 1. head white space;
 * 2. "1." and ".1" is true;
 * 3. before and after 'E' must be numbers, and after 'E', it must be Integer, cannot have '.' after E 
 * 4. there might be + and - in the beginning of the sequence, and might after 'E'
 * 5. tail white space;
 * 
 * Consider all the cases in this way:
 *  head white space, +/-, digit, '.', digit, 'E', +/-, digit, tail space;
 */
import java.lang.Character;
public class ValidNumber {

    public static boolean isNumber(String s) {
        if(s.length() == 0 || s == null)
            return false;
        boolean isNum = false;
        int i = 0;
        
        while(i < s.length() && Character.isWhitespace(s.charAt(i)))
            i++;
        
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            i++;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            i++;
            isNum = true;
        }
        
        if(i < s.length() && s.charAt(i) == '.'){
            i++;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                i++;
                isNum = true;
            }
        }
       
        if(i < s.length() && ( s.charAt(i) == 'e' || s.charAt(i) == 'E')){
            if(!isNum) return false;
                i++;
            isNum = false;
            if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
                i++;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                i++;
                isNum = true;
            }
        }
       
        while(i < s.length() && Character.isWhitespace(s.charAt(i)))
            i++;
        if(i < s.length()) return false;
        return isNum;
    }
	
	public static void main(String[] args) {
		String s = "2e10";
		System.out.println(ValidNumber.isNumber(s));
	}
}
