package leetcode;



/*
 * 1. dfs + recursion, cannot pass oj, limited time exceeded.
 * 2. dp. dp[i] = true means substring of s [0, i-1] can be segmented into space-separated sequence. 
 */
import java.util.Arrays;
import java.util.Set;
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return false;
        if(dict == null || dict.size() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
	public static void main(String[] args) {
	
	}
}
