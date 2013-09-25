package leetcode;


/*
 * use dynamic programming. dp[i] means the total number of the decode ways from 1 to i. 
 * 
 * the recursion relation is dp[i] = dp[i - 1] or dp[i] = dp[i - 1] + dp[i - 2]. think about this why. 
 * note1, base case dp[0] = 1.
 * 
 * note2, be careful here, i should be i >= 2. think about case: 10.  we should include i = 2. 
 */

public class DecodeWays {
	
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; //note1
        for(int i = 1; i <= s.length(); i++){
            if(s.charAt(i - 1) == '0')
                dp[i] = 0;
            else
                dp[i] = dp[i - 1];
            
            if(i >= 2 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) //note2
                dp[i] += dp[i - 2];
        }
       
        return dp[s.length()];
    }

	public static void main(String[] args) {
		
	}
}
