package leetcode;



/*
 *  be careful of the notes.
 *  don't forget to check pos and strs[i].length. 
 */
import java.lang.StringBuilder;
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        StringBuilder prefix = new StringBuilder();
        int pos = 0;
        char c = 0;
        while(true){
            int i = 0;
            for( ; i < strs.length; i++){
                if(i == 0 && !strs[i].isEmpty() && pos < strs[i].length()) c = strs[0].charAt(pos);//note1
                if(strs[i].isEmpty() || pos >= strs[i].length() || strs[i].charAt(pos) != c) break;//note2
            }
            if(i < strs.length)
                break;
            pos++;
            prefix.append(c);
        }
        
        return new String(prefix);
    }

	public static void main(String[] args) {
	
	}
}
