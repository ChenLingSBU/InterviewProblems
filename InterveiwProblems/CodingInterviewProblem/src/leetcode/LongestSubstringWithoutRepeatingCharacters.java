package leetcode;

/*
 * The basic idea about this problem is two pointers and sliding window. but there are a few tricks.
 * note1 and note2: 
 * 		  It can be first hit that scan from the leftmost to right, 
 * 		  every time if the current element was not appeared before, 
 * 		  we mark this element as true in the map, and then current element slides to the next element. 
 * 		  continue this way until we meet one element which is already appeared before, then we scan from the leftmost again
 * 		  set every element false until meet current element. 
 * 		  it comes up to our brain easily, however, it's not correct. 
 * 		  For case: "abcabcbb", we can use this method, and the result is correct, 
 * 		  but for case: "abcdbgemnqszw", if we use this method, the result would be : the longest substring is "bgemnqszw", 
 * 		  but the real longest substring is "cdbgemnqszw". We only need to jump over the two repeated element seperately, 
 * 		  not to jump over all the elements between two repeated elements
 * 		  so we should use the method for note1, while(s.charAt(i) != s.charAt(j)), not while(i<j).
 * note3:
 * 		we should calculate the maxlen at last to satisfiled the corner case: "abcd", if miss note3, the result would be 0,
 * 		but obviously, the result should be 4.
 * 
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
            int maxlen = 0;
            boolean[] map = new boolean[256];
            int i = 0;
            int j = 0;
            while(j<s.length()){
                if(!map[s.charAt(j)]){
                    map[s.charAt(j++)] = true;
                }else{
                    maxlen = Math.max(maxlen, j-i);
                    while(s.charAt(i) != s.charAt(j)){// note 1.
                        map[s.charAt(i++)] = false; 
                    }
                   i++;// note 2.
                   j++;
                }
            }
            return Math.max(maxlen, j-i);  // note 3.  
        }
    
    
	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
	}

}