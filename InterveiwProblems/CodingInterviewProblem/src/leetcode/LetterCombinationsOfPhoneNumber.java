package leetcode;

import java.util.ArrayList;

public class LetterCombinationsOfPhoneNumber {
    public static ArrayList<String> letterCombinations(String digits) {
        char[][] table = {                     // note, use 2D array as map.
        		          {' '},
        		          {}, 
        		          {'a','b','c'}, 
        		          {'d', 'e', 'f'}, 
        		          {'g', 'h', 'i'}, 
        		          {'j', 'k', 'l'},
        		          {'m', 'n', 'o'}, 
        		          {'p','q', 'r', 's'}, 
        		          {'t', 'u', 'v'}, 
        		          {'w', 'x', 'y', 'z'}
                		 };
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder strOut = new StringBuilder();
        doComb(digits, table, strOut, 0, result);
        return result;
    }
    
    public static void doComb(String digits, char[][] table, StringBuilder strOut, int curPos, ArrayList<String> result){
        if(curPos == digits.length()){
            result.add(strOut.toString());
            return;
        }
        
        int choices = table[digits.charAt(curPos) - '0'].length;// note, no need to convert String to int array, use method here instead.
        for(int i = 0; i < choices; i++){
        	strOut.append(table[digits.charAt(curPos) - '0'][i]);
            doComb(digits, table, strOut, curPos+1, result);
            strOut.setLength(strOut.length() - 1);      // remember to backwards one position here.
        }
    }
	public static void main(String[] args) {
		String digits = "23";
		System.out.println(LetterCombinationsOfPhoneNumber.letterCombinations(digits));
	}

}
