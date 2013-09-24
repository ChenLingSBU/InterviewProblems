package leetcode;

public class EditDistance {
	
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null ) return 0;
        if(word1.length() == 0 && word2.length() == 0) return 0;
        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= word1.length(); i++)
           dp[i][0] = i;
        for(int i = 1; i <= word2.length(); i++){
            dp[0][i] = i;
        }
        
        
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                   dp[i][j] = dp[i - 1][j - 1];
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        
        return dp[word1.length()][word2.length()];
       }

	public static void main(String[] args) {
		
	}
}
