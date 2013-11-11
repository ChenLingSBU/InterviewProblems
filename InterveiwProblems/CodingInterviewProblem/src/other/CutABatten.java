package other;


/*
 * it's a google's onsite interview question.
 * 
 * least cost to cut a batten
 * the cost of cutting each segment is the cost of the segment length, 
 * an array is storing each end point, 
 * eg:[0, 3, 7, 8, 11, 12], the batten length is 12, there are 4 cuting point
 * 
 * solution:
 * dp[i][j] means the min cost of cutting batten start at i, end at j. 
 * dp[i][j] = dp[i][i + k] + dp[i + k] [j]  enumerates. 
 */
import java.util.Arrays;
public class CutABatten {

	public int getMinCost(int[] a){
		if(a == null || a.length == 0) return -1;
		int n = a.length;
		int[][] dp = new int[n][n];
		
		Arrays.fill(dp, 0);
		
		for(int i = 2; i < n; i++){
			for(int j = 0; j + i < n; j++){
				int min = Integer.MAX_VALUE;
				for(int k = 1; k < i; k++)
					min = Math.min(min, dp[j][j + k] + dp[j + k][j + i] + a[j + i] - a[j]);
				dp[j][j+i] = min;
			}
		}
		
		return dp[0][n - 1];	
	}

	public static void main(String[] args) {

	}
}
