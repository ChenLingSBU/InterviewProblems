package leetcode;



/*
 * be careful to notes.
 */

public class CountAndSay {

    public static String countAndSay(int n) {
        if(n == 0) return "";
        if(n == 1) return "" + 1;
        StringBuilder[] strs = new StringBuilder[2];
        strs[0] = new StringBuilder();
        strs[1] = new StringBuilder();
        int previous = 1;
        int current = 0;
        strs[current].append(1);
        int i = 2;
        
        while(i <= n){
            int tmp = previous;
            previous = current;
            current = tmp;
            strs[current].setLength(0);
            int count = 1;
            for(int j = 0 ; j <= strs[previous].length(); j++){ // note 1
                if(j < strs[previous].length() && j != 0 && strs[previous].charAt(j) == strs[previous].charAt(j - 1)){ //note2
                	count++;
                	continue;
                }
                if(j == strs[previous].length() || (j != 0 && strs[previous].charAt(j) != strs[previous].charAt(j - 1))){ //note3
                	strs[current].append(count);
                	strs[current].append(strs[previous].charAt(j - 1));
                	count = 1; // note4
                }
            }
            i++;
         }
        return new String(strs[current]);
     }
    
   
	public static void main(String[] args) {
		int n = 6;
		System.out.println(CountAndSay.countAndSay(n));
	}
}
