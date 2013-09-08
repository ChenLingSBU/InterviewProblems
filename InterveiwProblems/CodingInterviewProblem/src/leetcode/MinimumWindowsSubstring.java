package leetcode;

/*
 * This problem is a classical two pointers slide problem. 
 * use two pointers begin and end, pointed at the 0 index of String S, 
 * 1. use end to scan from 0 index to right until all the elements in String T has been visited.
 * 2. use begin to scan from 0 index to right until begin cannot go any further.
 * 
 */

public class MinimumWindowsSubstring {
    public static String minWindow(String S, String T) {
        int[] expectedCount = new int[256];
        int[] realCount = new int[256];
        int count = 0;
        char[] arrayS = S.toCharArray();
        char[] arrayT = T.toCharArray();
        int minStart = 0;
        int minLen = arrayS.length + 1;;
        
        for(int i = 0; i < arrayT.length; i++){
            expectedCount[arrayT[i]]++;
        }
        
        for(int begin = 0, end = 0; end < arrayS.length; end++){
            char ch = arrayS[end];
            if(expectedCount[ch] == 0)
                continue;
            if(++realCount[ch] <= expectedCount[ch])
                count++;
                
            if(count == arrayT.length){
                
                while(expectedCount[arrayS[begin]] == 0 || realCount[arrayS[begin]] > expectedCount[arrayS[begin]] ){
                    if(realCount[arrayS[begin]] > expectedCount[arrayS[begin]])
                        realCount[arrayS[begin]]--;
                    
                    begin++;
                }
                
                int len = end - begin +1;
                if(minLen > len ){
                    minLen = len;
                    minStart = begin;
            }
           
            }
        }
        
        return minLen > arrayS.length ? new String("") : S.substring(minStart,minStart+ minLen);
        
    }
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.print(MinimumWindowsSubstring.minWindow(S, T));

	}

}
