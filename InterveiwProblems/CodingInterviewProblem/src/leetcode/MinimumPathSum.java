package leetcode;



/*
 * it's a DP problem. 
 * 1. we can use ordinary 2-dimensional DP 
 * 2. for using less space, we can use rolling array as here.
 */
import java.util.Arrays; 
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;
        if(col == 0) return 0;
        int[] steps = new int[col];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for(int i = 0; i < row; i++){
            steps[0] = steps[0] + grid[i][0];
            for(int j = 1; j < col; j++){
                steps[j] = Math.min(steps[j - 1], steps[j]) + grid[i][j];
            }
        }
        
        return steps[col - 1];
    }
	
	public static void main(String[] args) {
	
	}
}
