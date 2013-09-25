package leetcode;


/*
 * two algorithms: 
 * 1. Catalan Numbers O(n) time, O(1) space.
 * 2. DP.  O(n^2) time, O(n) space.
 * 
 * dp[i] means there are how many kinds of BST from 0 to i.
 * 
 * assume current node is n, how many kinds of BST can be if the root is n?
 * 
 * the answer is assume if we know leftCount and rightCount to indicate how many different BST of n.left and n.right
 * Thus we only need multiplay leftCount by rightCount.
 * 
 * example:
 * count[2] = count[0] * count[1]  1 as root, left should be null
 * 			+ count[1] * count[0]  2 as root, right should be null
 * 
 * Count[3] = Count[0] * Count[2]  1 as root,
            + Count[1] * Count[1]  2 as root,
            + Count[2] * Count[0]  3 as root,
 * 
 */

public class UniqueBinarySearchTrees {
	
	public int numTreesCatalanNumbers(int n) {
	    int c = 1;
	    for (int i = 2; i <= n; i++)
	        c = 2*(2*i-1)*c/(i+1);
	    return c;
	}

	   public int numTreesDP(int n) {
	        if(n == 0) return 1;
	        int[] dp = new int[n + 1];
	        dp[0] = 1;  // null tree, size should be 1
	        dp[1] = 1; 
	        
	        for(int i = 2; i <= n; i++){
	            for(int j = 0; j < i; j++){
	                dp[i] += dp[j]*dp[i - j - 1];
	            }
	        }
	        
	        return dp[n];
	    }
	public static void main(String[] args) {

		
	}
}
