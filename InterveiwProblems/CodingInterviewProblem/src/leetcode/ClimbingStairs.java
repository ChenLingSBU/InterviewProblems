package leetcode;


/*
 * Use DP. the idea is similar to "Decode Ways"
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n == 0) return 0;
        
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for(int i = 1; i <= n; i++ ){
            if(i >= 2)
                ways[i] = ways[i - 1] + ways[i - 2];
            else
                ways[i] = ways[i - 1];
        }
        
        return ways[n];
    }
	
	public static void main(String[] args) {
		
	}

}
