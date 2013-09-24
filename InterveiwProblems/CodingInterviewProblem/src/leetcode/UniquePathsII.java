package leetcode;


/*
 * the recurrent relation is similar as UniquePaths
 * but check whether obstacleGrid[i][j] == 1;
 * 
 */

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0) return 0;
        if(obstacleGrid[0][0] == 1) return 0;
        int[] maxV = new int[n];
        maxV[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) 
                     maxV[j] = 0;
                else if(j > 0)
                     maxV[j] = maxV[j - 1] + maxV[j];
            }
            
        }
        
        return maxV[n - 1];
     }
	public static void main(String[] args) {
		
	}
}
