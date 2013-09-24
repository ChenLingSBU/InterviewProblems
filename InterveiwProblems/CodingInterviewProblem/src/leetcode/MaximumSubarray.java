package leetcode;



public class MaximumSubarray {
	
    public int maxSubArray(int[] A) {
        int sum = A[0];
        int maxSum = sum;
        
        for(int i = 1; i < A.length; i++){
            sum = Math.max(sum + A[i], A[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
      }

	public static void main(String[] args) {
		

	}

}
