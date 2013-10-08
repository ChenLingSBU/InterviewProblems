package leetcode;


/*
 * use recursion and back trace.
 * the rule of IP address is, 
 * 1. the rule is ip address has four parts, assume each part is p, thus 0 <= p <= 255.
 * 2. 0 cannot be the first digit if there are more than one digits.
 * 
 * notes:
 * 1. base case
 * 2. edge case, don't forget this.
 * 3. 0 cannot be the first digit if there are more than one digits.
 */

import java.util.ArrayList;

public class RestoreIPAddress {

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        String prev = "";
        restoreIpAddresses(s, prev, result, 0, 0);
        return result;
    }
    
    public static void restoreIpAddresses(String word, String prev, ArrayList<String> result, int start, int partNum){
        if(word.length() - start > (4 - partNum)*3 || (word.length() - start)< (4 - partNum) ) //note1.
            return;
        if(start == word.length() && partNum == 4){
            result.add(prev.substring(0, prev.length() - 1));
            return;
        }else{
            int num = 0;
            for(int i = start; i < start + 3; i++ ){
            	if(i >= word.length())  //note2
            		break;
               num = num*10 + (word.charAt(i) - '0');
               if(num <= 255){
                   prev = prev + word.charAt(i);
                   restoreIpAddresses(word, prev + ".", result, i + 1, partNum + 1);
               }
               if(i == start && num == 0)//note3
                  break;
            }
        }
    }
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(RestoreIPAddress.restoreIpAddresses(s));
	}
}
