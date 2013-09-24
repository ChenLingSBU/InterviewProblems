package leetcode;

/*
 * comment: 
 * it's an easy DP practice problem. notes are as below:
 * 
 *  here the index of the starting position is (0,0), so the index of the ending position is (m - 1, n - 1);
 *  and there's a restriction that in the first row, it can only be move from left, and similar to the first col. 
 *  use rolling array to save space.
 *  
 *  if don't use rolling array, it should be like this :
 *  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 */


public class UniquePaths {

    public int uniquePaths(int m, int n) {
        
        int[] maxV = new int[n];
        maxV[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                maxV[j] = maxV[j - 1] + maxV[j];
            }
        }
        
        return maxV[n - 1];
    }
	
	public static void main(String[] args) {
	
	}
}
