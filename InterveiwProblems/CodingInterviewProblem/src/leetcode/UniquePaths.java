package leetcode;



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
