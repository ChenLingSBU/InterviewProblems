package leetcode;


/*
 *  be careful of the corner cases.
 *  input: " " ,  "A ", ""
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int pos = s.length() - 1;
        int end = pos;
        while( pos >= 0 && s.charAt(pos) == ' ') end = --pos;
        
        if(pos < 0) return 0;
        
        while( pos >= 0 && s.charAt(pos) != ' ') pos--;
        
        return end - (pos+1) +1;
    }
    
	public static void main(String[] args) {
		String s = " ";
		
	}
}
